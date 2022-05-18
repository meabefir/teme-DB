import { toHaveAccessibleDescription } from '@testing-library/jest-dom/dist/matchers';
import React, { Component, Fragment } from 'react'

export default class AuthorSelect extends Component {
    constructor(props) {
        super(props);

        this.state = {
            names: []
        }

        this.changeAuthorName = this.changeAuthorName.bind(this)
        this.promise = fetch("https://jsonplaceholder.typicode.com/users")
    }

   async componentDidMount() {
        this.promise.then((res) => res.json())
        .then((users) => {
            console.log(users)

            let userNames = users.map(user => user.name);
            this.setState({
                names: userNames
            })
            
        });
    }

    changeAuthorName(e) {
        this.props.changeAuthorName(e.target.value)
    }

  render() {
    let options = []
    if (this.state.names.length > 0) {
        for (let i = 0; i < this.state.names.length; i++) {
            options.push(<option key={i} value={this.state.names[i]}>{this.state.names[i]}</option>)
        }
    }

    return (
        <Fragment>
            <label htmlFor="authors">Choose an author:</label>
            <select id="select" name="authors" onChange={this.changeAuthorName}>
                <option value="All">All</option>
                {this.state.names.length > 0 && options}
            </select>
        </Fragment>
    )
  }
}
