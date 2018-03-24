import React, { Component } from 'react';
import './App.css';
import Order from './Order'

class Products extends Component {

  /**************************************************************
  * Objective: Constructor
  *
  *   State variables:
  *     value: searched text
  *     products: products found in the database,
  *     orderList: products added to order list,
  *     restaurantId: props.restaurantId,
  *     restaurantName: props.restaurantName,
  *
  *   Getting products from database with restaurantId
  *
  * Author: Felipe Iserte Bonfim (felipe.iserte@gmail.com)
  *
  * Date: 19th March, 2018 - 6:14 PM
  ***************************************************************/
  constructor(props) {
    super(props);
    this.state = {
      value: '',
      products: [],
      orderList: [],
      restaurantId: props.restaurantId,
      restaurantName: props.restaurantName,
    };

    if(this.state.restaurantId != null)  {
      fetch("http://localhost:8080/getProducts?restaurantId=" + this.state.restaurantId)
        .then(response => response.json())
        .then(productList => {
            this.setState({
              products: productList
            });
        });
    }

  }

  /**************************************************************
  * Objective: handleProductClick
  *
  *   Add product to order list
  *
  * Author: Felipe Iserte Bonfim (felipe.iserte@gmail.com)
  *
  * Date: 24th March, 2018 - 10:11 PM
  ***************************************************************/
  handleProductClick(product) {
    // TODO Implement some kind of overlay form to let the user set how many
    // items they want of this product instead of 1.
    product.quantity = 1;
    this.state.orderList.push(product);
    this.setState({orderList:this.state.orderList});
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
      <li key={item.productId} onClick={() => this.handleProductClick(item)} >
        {item.name}
        <div className="address">{item.price}</div>
      </li>)
  }

  /**************************************************************
  * Objective: Render the App Component
  *
  *   Creates a form, a input text box, a submit button and the result.
  *
  * Author: Felipe Iserte Bonfim (felipe.iserte@gmail.com)
  *
  * Date: 19th March, 2018 - 6:14 PM
  ***************************************************************/
  render() {
    return (
      <div className="App">

        <div className="App-header">
          <div className="App-title">SKIP the DISHES</div>
        </div>

        <div className="searchPage">
          <h1 className="title-lg text-light">A Better Way to Get Your Food</h1>
          <h2 className="title-sm text-light margin-top-lg">Order From Local Restaurants You Love</h2>

          <form onSubmit={this.handleSearch}>
          {this.state.restaurantName}
          <ul className="restaurantList" >{this.renderProducts(this.state.products)}</ul>

          </form>
        </div>
        <Order products={this.state.orderList} restaurantId={this.state.restaurantId}
            restaurantName={this.state.restaurantName} />

      </div>
    );
  }
}

export default Products;
