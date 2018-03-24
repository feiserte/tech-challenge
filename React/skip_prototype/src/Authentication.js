import React, { Component } from 'react';
import './App.css';
import Restaurants from './Restaurants';
import ReactDOM from 'react-dom';

class Authentication extends Component {

  /**************************************************************
  * Objective: Constructor
  *
  *   State variables:
  *     email: email address
  *     password: user password
  *
  *   Added binding to 3 methods that will use the state props
  *     handleEmailChange
  *     handlePasswordChange
  *     handleLogin
  *
  * Author: Felipe Iserte Bonfim (felipe.iserte@gmail.com)
  *
  * Date: 16th March, 2018 - 6:39 PM
  ***************************************************************/
  constructor(props) {
    super(props);
    this.state = {
      email: '',
      password: '',
      authResponse: ''
    };

    this.handleEmailChange = this.handleEmailChange.bind(this);
    this.handlePasswordChange = this.handlePasswordChange.bind(this);
    this.handleLogin = this.handleLogin.bind(this);
  }

  /**************************************************************
  * Objective: Handle Text change
  *
  *   Update the State variable 'value'
  *   Prevent default method acation
  *
  * Author: Felipe Iserte Bonfim (felipe.iserte@gmail.com)
  *
  * Date: 16th March, 2018 - 6:41 PM
  ***************************************************************/
  handleEmailChange(event) {
    this.setState({email: event.target.value});
    event.preventDefault();
  }

  /**************************************************************
  * Objective: Handle Text change
  *
  *   Update the State variable 'value'
  *   Prevent default method acation
  *
  * Author: Felipe Iserte Bonfim (felipe.iserte@gmail.com)
  *
  * Date: 16th March, 2018 - 6:41 PM
  ***************************************************************/
  handlePasswordChange(event) {
    this.setState({password: event.target.value});
    event.preventDefault();
  }

  /**************************************************************
  * Objective: Handle Search / form submit calls this function
  *
  *   Call a Rest get web service to get information regarding all restaurants
  *   Filter the list with the searched text
  *
  * Author: Felipe Iserte Bonfim (felipe.iserte@gmail.com)
  *
  * Date: 16th March, 2018 - 7:41 PM
  ***************************************************************/
  handleLogin(event) {

    fetch("http://localhost:8080/userAuthentication?email="+ this.state.email +"&password=" + this.state.password, {
      method: 'POST',
      headers: new Headers({
                 'Content-Type': 'application/json', // <-- Specifying the Content-Type
        })
    }).then((response) => response.json())
      .then((responseText) => {
        console.info(responseText);

        if(responseText.authenticated === true) {
          window.sessionStorage.setItem("loggedCustomerId", responseText.customer.id);
          window.sessionStorage.setItem("loggedCustomer", JSON.stringify(responseText.customer));
          ReactDOM.render(<Restaurants />, document.getElementById('root'))
        } else {
          document.getElementById("msg").innerHTML = responseText.errorMessage;
        }
      })
      .catch((error) => {
          console.error(error);
          document.getElementById("msg").innerHTML = "Error trying to connect to the server. Please contact the admin.";
    });

    event.preventDefault();
  }

  /**************************************************************
  * Objective: Render the App Component
  *
  *   Creates a form, a input text box, a submit button and the result.
  *
  * Author: Felipe Iserte Bonfim (felipe.iserte@gmail.com)
  *
  * Date: 16th March, 2018 - 6:14 PM
  ***************************************************************/
  render() {
    return (
      <div className="Authentication">

        <div className="App-header">
          <div className="App-title">SKIP the DISHES</div>
        </div>

        <div className="loginPage" id="loginPage">
          <h1 className="title-lg text-light">Login</h1>

          <form onSubmit={this.handleLogin}>
            <input type="text" onChange={this.handleEmailChange} placeholder="Email address" />
            <br/>
            <input type="password" onChange={this.handlePasswordChange} placeholder="Password" />
            <br/>
            <input type="submit" value="Login" />
            <div id="msg" />
          </form>
        </div>
      </div>
    );
  }
}

export default Authentication;
