import React, { Component } from 'react';
import './App.css';
import ReactDOM from 'react-dom';
import Products from './Products';

class Restaurants extends Component {

  /**************************************************************
  * Objective: Constructor
  *
  *   State variables:
  *     value: searched text
  *     restaurants: restaurants found in the database
  *
  *   Added binding to 2 methods that will use the state props
  *     handleChange
  *     handleSearch
  *
  * Author: Felipe Iserte Bonfim (felipe.iserte@gmail.com)
  *
  * Date: 16th March, 2018 - 6:14 PM
  ***************************************************************/
  constructor(props) {
    super(props);
    this.state = {
      value: '',
      restaurants: []
    };

    this.handleChange = this.handleChange.bind(this);
    this.handleSearch = this.handleSearch.bind(this);
    this.handleRestaurantClick = this.handleRestaurantClick.bind(this);
  }

  /**************************************************************
  * Objective: Handle Text change
  *
  *   Update the State variable 'value'
  *   Prevent default method acation
  *
  * Author: Felipe Iserte Bonfim (felipe.iserte@gmail.com)
  *
  * Date: 16th March, 2018 - 6:14 PM
  ***************************************************************/
  handleChange(event) {
    this.setState({value: event.target.value});
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
  * Date: 16th March, 2018 - 6:14 PM
  * Last update: 16th March, 2018 - 5:28 PM
  ***************************************************************/
  handleSearch(event) {

    fetch("http://localhost:8080/getRestaurants")
      .then(response => response.json())
      .then(restaurantList => {

        if(this.state.value === '') {
          this.setState({
            restaurants: restaurantList
          });
        } else {
          var wantedData = restaurantList.filter(i => {
            return i.name.toLowerCase().indexOf(this.state.value.toLowerCase()) >= 0;
          });
          this.setState({
            restaurants: wantedData
          });
        }

    });

    event.preventDefault();

  }

  /**************************************************************
  * Objective: Go to the products page passing the restaurantId
  *
  * Author: Felipe Iserte Bonfim (felipe.iserte@gmail.com)
  *
  * Date: 19th March, 2018 - 9:46 PM
  ***************************************************************/
  handleRestaurantClick(restaurant) {

    ReactDOM.render(<Products restaurantId={restaurant.restaurantId}
        restaurantName={restaurant.name} />, document.getElementById('root'))
  }

  /**************************************************************
  * Objective: Render restaurants information
  *
  *   Creates a li tag for each resturant on the list
  *
  * Author: Felipe Iserte Bonfim (felipe.iserte@gmail.com)
  *
  * Date: 16th March, 2018 - 5:28 PM
  ***************************************************************/
  renderRestaurants(restaurants) {
    return restaurants.map(item =>
      <li key={item.restaurantId} onClick={() => this.handleRestaurantClick(item)} >
        {item.name}
        <div className="address">{item.address}</div>
      </li>)
  }

  /**************************************************************
  * Objective: Render the App Component
  *
  *   Creates a form, a input text box, a submit button and the result.
  *
  * Author: Felipe Iserte Bonfim (felipe.iserte@gmail.com)
  *
  * Date: 16th March, 2018 - 5:28 PM
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
            Search <input type="text" onChange={this.handleChange} placeholder="restaurant name" />
            <br/>
            <input type="submit" value="Search" />
            <ul className="restaurantList" >{this.renderRestaurants(this.state.restaurants)}</ul>
          </form>
        </div>

      </div>
    );
  }
}

export default Restaurants;
