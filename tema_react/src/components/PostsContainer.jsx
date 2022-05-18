import React, { Component, Fragment } from 'react'
import Post from './Post';

export default class PostsContainer extends Component {
    constructor(props) {
        super(props);

        this.state = {
            posts: [],
            page: 0,
            currentPosts: []
        }
        
        
        this.maxPage = 33
        this.minPage = 0
        
        this.nextPage = this.nextPage.bind(this)
        this.prevPage = this.prevPage.bind(this)
        this.deletePost = this.deletePost.bind(this)

        this.promise = fetch("https://jsonplaceholder.typicode.com/posts")
        .then((res) => res.json())
        .then((posts) => {
        return fetch("https://jsonplaceholder.typicode.com/users")
            .then((res) => res.json())
            .then((users) => {
            
            posts = posts.map((post) => {
                return {
                ...post,
                user: users[
                    users.indexOf(users.find((u) => u.id === post.userId))
                ],
                comments: [],
                };
            });

            return fetch("https://jsonplaceholder.typicode.com/comments")
                    .then((res) => res.json())
                    .then((comments) => {
                    for (let comment of comments) {
                        posts[
                        posts.indexOf(posts.find((p) => p.id === comment.postId))
                        ].comments.push(comment);
                    }
                    
                    this.shuffle(posts);
                    
                    // console.log(posts)
                
                    posts = posts.map(post => ({...post, urlPromise: fetch("https://picsum.photos/700/300")}))
                    posts = posts.map(post => ({...post, deleted: false}))
                    return posts;
                });
            });
        });
    }

    shuffle(array) {
        let currentIndex = array.length,
          randomIndex;
      
        while (currentIndex !== 0) {
          randomIndex = Math.floor(Math.random() * currentIndex);
          currentIndex--;
      
          [array[currentIndex], array[randomIndex]] = [
            array[randomIndex],
            array[currentIndex],
          ];
        }
      
        return array;
      }

    componentDidMount() {
        this.promise.then(posts => {
            console.log(posts)
            this.setState({
                posts,
                currentPosts: posts.filter(((post, idx) => idx >= this.state.page*3 && idx < (this.state.page+1)*3))
            })
        })
    }

    async nextPage() {
        this.setState((prevState, props) => {
            let newPage = prevState.page + 1
            console.log(newPage)
            return {
                currentPosts: prevState.posts.filter(((post, idx) => idx >= newPage*3 && idx < (newPage+1)*3)),
                page: prevState.page < this.maxPage ? newPage : this.maxPage
            }
        })
        document.documentElement.scrollTop = 0;
    }

    async prevPage() {
        this.setState((prevState, props) => {
            let newPage = prevState.page - 1
            return {
                currentPosts: prevState.posts.filter(((post, idx) => idx >= newPage*3 && idx < (newPage+1)*3)),
                page: prevState.page > 0 ? newPage : this.minPage
            }
        })
        document.documentElement.scrollTop = 0;
    }

    deletePost(id) {
        console.log("deleting post with id ", id)
        // this.setState((prevState, props) => ({
        //     posts: prevState.posts.map(post => post.id === id ? {...post, deleted: true} : post)
        // }))

        this.setState((prevState, props) => ({
            currentPosts: prevState.currentPosts.map(post => post.id === id ? {...post, deleted: true} : post)
        }))
    }

    addPostToPage(post) {
        this.setState((prevState, props) => ({
            currentPosts: prevState.currentPosts.unshift(post),
            posts: prevState.posts.splice(this.state.page * 3, 0, post)
        }))
    }

  render() {
    let postsRender = []
    let myPosts = this.props.addedPosts.concat(this.state.currentPosts)
    // let posts = this.state.posts.filter((post, idx) => idx >= this.state.page*3 && idx < (this.state.page+1)*3)
    console.log(myPosts)
    for (let i = 0; i < myPosts.length; i++) {
        let post = myPosts[i];
        if (post.deleted) continue
        if (this.props.authorName !== 'All' && post.user.name !== this.props.authorName) continue
        postsRender.push(<Post key={i} id={post.id} title={post.title} url={post.urlPromise} subHeaders={[post.user.name, post.user.email, post.user.phone]} onDelete={this.deletePost}/>)
        // postsRender.push(<Post key={i} id={post.id} title={post.title} url={fetch("https://picsum.photos/700/300")} subHeaders={[post.user.name, post.user.email, post.user.phone]} onDelete={this.deletePost}/>)
        // posts.push(<Post key={i} id={post.id} title={post.title} url={post.url} subHeaders={[post.user.name, post.user.email, post.user.phone]}  />)
    }

    return (
        <Fragment>
            <div className="posts" id="posts">
                {postsRender.length > 0 && postsRender}
            </div>
            <div className="page-nav">
                <button className={`${this.state.page !== this.minPage ? "" : "hidden"}`} onClick={this.prevPage}>previous</button>
                <button className={`${this.state.page !== this.maxPage ? "" : "hidden"}`} onClick={this.nextPage}>next</button>
            </div>
        </Fragment>
    )
  }
}
