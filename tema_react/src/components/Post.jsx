import { toHaveDisplayValue } from '@testing-library/jest-dom/dist/matchers';
import React, { Component } from 'react'

export default class Post extends Component {
    constructor(props) {
        super(props);

        this.state = {
            url: "",
        }
    }

    componentDidMount() {
        this.props.url.then(res => {
            this.setState({
                url: res.url
            })
        })
    }

    componentWillUnmount() {
        console.log("unmount")
    }

  render() {
    let subHeaders = []
    for (let i = 0; i < this.props.subHeaders.length; i++) {
        subHeaders.push(<div key={i*2}>{this.props.subHeaders[i]}</div>)

        if (i !== this.props.subHeaders.length-1) {
            subHeaders.push(<div key={i*2+1} className="separator">●</div>)
        }
    }

    return (
       <div className="post">
            <div className="content">
                <h1>
                    {this.props.title}
                </h1>
                <div className="sub-header">
                    {subHeaders}
                </div>
            </div>
            <div className="edit-container">
                <button>Edit</button>
                <button onClick={() => this.props.onDelete(this.props.id)}>Delete</button>
                {/* <button>Delete</button> */}
            </div>
            {/* <img src={this.props.url} alt="" /> */}
            <img src={this.state.url} alt="" />
            <div className="content">
                <p>
                    Lorem ipsum dolor sit, amet consectetur adipisicing elit. Nesciunt aperiam odio doloremque officia quo nulla soluta consequatur provident, repellendus, repellat quos saepe dolore id nemo, recusandae assumenda asperiores sapiente reiciendis neque ipsum animi sit voluptatem accusamus. Est, praesentium nisi. Aliquid, architecto perspiciatis hic illum obcaecati facere ut illo nam quae labore, animi aperiam molestiae totam pariatur. Provident repellat excepturi sint ipsam itaque ratione distinctio dolorum sed aperiam voluptatum, unde magni. Ut eos nostrum dolorum voluptatibus sequi suscipit autem natus ratione tempore. Facilis minus natus voluptatibus! Maxime provident cum ullam quo sed animi accusantium voluptas, dolores soluta molestiae similique corporis at dolorem fugit sint nesciunt sit natus, odit neque ea. Eum voluptates vitae harum animi sit exercitationem delectus illum est provident dolore beatae itaque, fuga repellat voluptatibus hic error quam unde? Repellat dignissimos dolorem minus enim, veniam delectus dolorum fuga vero laudantium, voluptates officiis corrupti in consequatur praesentium dolore reiciendis sapiente, eaque debitis doloribus perspiciatis possimus recusandae. Qui id odit voluptatem voluptate recusandae. Eaque nesciunt repellendus repellat aperiam necessitatibus ex labore sint. Molestias atque veritatis minus debitis eaque accusantium iste consequuntur dicta distinctio maiores hic dignissimos praesentium rem illo magni, sunt enim? Labore explicabo quas in at delectus rem optio ex, praesentium mollitia dicta autem quos excepturi itaque, reiciendis inventore. Saepe labore a sunt consectetur eum. Sint iusto consectetur repudiandae illo cupiditate aliquam assumenda nam unde sapiente eius doloremque sit eos ipsum explicabo, esse perferendis a dolore eaque consequatur voluptatum sed? Consequuntur libero explicabo distinctio tempore minus illo temporibus expedita, delectus facilis rem consectetur eum ab assumenda exercitationem, facere quod, eos provident! Dignissimos magnam voluptatibus repellendus at quam amet ea quo dolore blanditiis quidem ad voluptas quod reiciendis voluptate alias atque hic necessitatibus aliquam debitis corrupti animi repellat, voluptates doloremque quasi. Exercitationem, fugit illum ratione sed quia debitis saepe unde asperiores!
                </p>
            </div>
        </div>
    )
  }
}
