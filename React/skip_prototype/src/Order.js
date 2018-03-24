import React, { Component } from 'react';
import './App.css';
import ReactDOM from 'react-dom';

class Order extends Component {

  /**************************************************************
  * Objective: Constructor
  *
  *   State variables:
  *     value: searched text
  *     products: list of products found in the database,
  *     restaurantId: props.restaurantId,
  *     restaurantName: props.restaurantName,
  *
  *   Added binding to 2 methods that will use the state props
  *     renderProducts
  *     createOrder
  *
  * Author: Felipe Iserte Bonfim (felipe.iserte@gmail.com)
  *
  * Date: 19th March, 2018 - 9:50 PM
  ***************************************************************/
  constructor(props) {
    super(props);
    this.state = {
      value: '',
      products: props.products,
      restaurantId: props.restaurantId,
      restaurantName: props.restaurantName,
    };

    this.renderProducts = this.renderProducts.bind(this);
    this.createOrder = this.createOrder.bind(this);
  }

  /**************************************************************
  * Objective: Remove product form order
  *
  * Author: Felipe Iserte Bonfim (felipe.iserte@gmail.com)
  *
  * Date: 19th March, 2018 - 10:27 PM
  ***************************************************************/
  handleProductClick(product) {

    var array = this.state.products;
    var index = array.indexOf(product);
    array.splice(index, 1);
    this.setState({products: array });
  }

  /**************************************************************
  * Objective: Render products information
  *
  *   Creates a li tag for each product on the list
  *
  * Author: Felipe Iserte Bonfim (felipe.iserte@gmail.com)
  *
  * Date: 19th March, 2018 - 9:53 PM
  ***************************************************************/
  renderProducts(products) {
    return products.map(item =>
      <li key={item.productId} onClick={() => this.handleProductClick(item.productId)} >
          {item.name}
          <div className="address">{item.price}</div>
      </li>)
  }

  /**************************************************************
  * Objective: Create Order
  *
  *   Call API to createOrder with customer (properties: id),
  *     productList (properties: productId, restaurantId, price, quantity)
  *
  * Author: Felipe Iserte Bonfim (felipe.iserte@gmail.com)
  *
  * Date: 24th March, 2018 - 12:01 PM
  ***************************************************************/
  createOrder() {
    let productList = JSON.stringify(this.state.products);
    let customer = JSON.parse(window.sessionStorage.getItem("loggedCustomer"));

    fetch("http://localhost:8080/createOrder?customerId=" + customer.id, {
      method: 'POST',
      headers: new Headers({
          'Accept': 'application/json',
          'Content-Type': 'application/json',
        }),
        body: productList
    }).then((response) => response.json())
      .then((responseText) => {
        console.info(responseText);
        document.getElementById("msg").innerHTML = responseText.status;
      })
      .catch((error) => {
          console.error(error);
          document.getElementById("msg").innerHTML = "Error trying to connect to the server. Please contact the admin.";
    });
  }

  /**************************************************************
  * Objective: Render the App Component
  *
  *   Creates a form, a input text box, a submit button and the result.
  *
  * Author: Felipe Iserte Bonfim (felipe.iserte@gmail.com)
  *
  * Date: 19th March, 2018 - 10:35 PM
  ***************************************************************/
  render() {
    return (
      <div className="Order">

          <h2 className="title-sm text-light margin-top-lg">Order</h2>
          {this.state.restaurantName}
          <ul className="orderList" >{this.renderProducts(this.state.products)}</ul>

          <button onClick={this.createOrder} >Create order</button>

          <div id="msg" />
      </div>
    );
  }
}

export default Order;
