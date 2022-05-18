import React from "react";
import AuthorSelect from "./AuthorSelect";
import Modal from "./Modal";
import PostsContainer from "./PostsContainer";

class Container extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            modalHidden: true,
            authorName: "All",
            addedPosts: []
        }

        this.toggleModal = this.toggleModal.bind(this)
        this.changeAuthorName = this.changeAuthorName.bind(this)
        this.addPost = this.addPost.bind(this)
        this.getRndInteger = this.getRndInteger.bind(this)
    }

    toggleModal() {
        this.setState((prevState, props) => ({
            modalHidden: !prevState.modalHidden
        }))
    }

    getRndInteger(min, max) {
        return Math.floor(Math.random() * (max - min) ) + min;
      }

    addPost(post) {
        console.log(post)
        post = {
            id: this.getRndInteger(0, 12312412412),
            title: post.title,
            url: fetch("https://picsum.photos/700/300"),
            user: {
                name: post.author,
                email: post.username,
                phone: post.date
            }
        }

        this.setState((prev, props) => {
            let newPosts = prev.addedPosts
            newPosts.push(post)
            return {
                addedPosts: newPosts
            }
        })
        console.log("after adding post")
        console.log(this.state.addedPosts)
    }

    changeAuthorName(name) {
        console.log(name)
        this.setState({
            authorName: name
        })
    }

    render() {
      return (
        <div className="container">
            <div className="navbar">
                <div>TRAVEL UPDATES</div>
                <div>REVIEWS</div>
                <div>AOBUT</div>
                <div>CONTACT</div>
            </div>
        
            <button id="buttonAdd" className="button-add" onClick={this.toggleModal}>
                <pre className="icon">+</pre> ADD ARTICLE
            </button>
            
            <AuthorSelect changeAuthorName={this.changeAuthorName} />

            <PostsContainer authorName={this.state.authorName} addedPosts={this.state.addedPosts} />

            <Modal hidden={this.state.modalHidden} toggleModal={this.toggleModal} addPost={this.addPost} />
        </div>

        )
    }
}

export default Container;