import React, { Component } from 'react'

export default class Modal extends Component {
    constructor(props) {
        super(props);

        this.state = {
            title: "",
            username: "",
            author: "",
            date: "",
            url: "",
            content: ""
        }

        this.handleChange = this.handleChange.bind(this)
    }

    handleChange(e) {
        this.setState((prevState, props) => {
            prevState[e.target.name] = e.target.value
            return {
                ...prevState
            }
        })
    }

  render() {
    return (
        <div className={`modal-container ${this.props.hidden ? "hidden" : ""}`}>
            <div className="modal blue-b">
                <div className="m-title">Add/Edit article</div>
                <div className="flex-line">
                    <input name="title" type="text" style={{marginRight: 50}} placeholder="Please enter title" onChange={this.handleChange} />
                    <input name="username" type="text" placeholder="Please enter username" onChange={this.handleChange} />
                </div>
                <div className="flex-line">
                    <input name="author" type="text" style={{marginRight: 50}} placeholder="Please enter author" onChange={this.handleChange} />
                    <input name="date" type="text" placeholder="Please enter date" onChange={this.handleChange} />
                </div>
                <div className="flex-line">
                    <input name="url" type="text" placeholder="Please enter image url" onChange={this.handleChange} />
                </div>
                <div className="flex-line">
                    <textarea name="content" placeholder="Please enter content" rows="7" onChange={this.handleChange} />
                </div>
                <div className="flex-line">
                    <button className="button-add" onClick={this.props.toggleModal}>CANCEL</button>
                    <button className="button-add pink" onClick={() => {
                        this.props.toggleModal()
                        this.props.addPost(this.state)
                    }}>SAVE</button>
                </div>
            </div>
        </div>
    )
  }
}
