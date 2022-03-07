import './App.css';
import React, { useEffect, useState } from 'react';

function App() {
  const [search, setSearch] = useState('');
  const [data, setData] = useState([]);
  const [country, setCountry] = useState([]);
  const [selectValue, setSelect] = useState('All');

  const handleSearch = (e) => {
    setSearch(e.target.value);
    if(selectValue == 'All'){
      fetch(`http://localhost:8080/merchants/?name=${search}`)
      .then(response => response.json())
      .then(json => setData(json));
    }
    else {
      fetch(`http://localhost:8080/merchants/?name=${search}&country=${selectValue}`)
      .then(response => response.json())
      .then(json => setData(json));
    }
  }

  useEffect(() => {
    fetch('http://localhost:8080/merchants/countries')
    .then(function(res) {
        return res.json();
    }).then((json)=> {
      console.log(json)
        setCountry(json)
    });
    if(selectValue == 'All'){
      fetch(`http://localhost:8080/merchants/?name=${search}`)
      .then(response => response.json())
      .then(json => setData(json));
    }
    else {
      fetch(`http://localhost:8080/merchants/?name=${search}&country=${selectValue}`)
      .then(response => response.json())
      .then(json => setData(json));
    }
  }, [])

  const handleChange = (e) => {
    setSelect(e.target.value);
    if(e.target.value == 'All'){
      fetch(`http://localhost:8080/merchants/?name=${search}`)
      .then(response => response.json())
      .then(json => setData(json));
    }
    else {
      fetch(`http://localhost:8080/merchants/?name=${search}&country=${e.target.value}`)
      .then(response => response.json())
      .then(json => setData(json));
    }
  }

  return (
    <div className="App">
      <header className="App-header">
        <form>
          <div>
            <label>
              <div>Select Country:</div>

              <select value={selectValue} onChange={handleChange}>
              <option>All</option> 
              {
                  country.map((v) => {
                    return <option>{v}</option>
                  })
                } </select>
            </label>
          </div>
          <input className="input-search" placeholder="Enter Merchant Name" type="text" value={search} onChange={handleSearch} />
        </form>
        {
          data.map(merchant => (
            <div key={merchant.id}>
              <h6>Merchant : {merchant.name}</h6>
              <h5>Country : {merchant.country}</h5>
              <h5>Website : <a href={merchant.websiteUrl}>{merchant.websiteUrl}</a></h5>
              <h5>Platforms: {merchant.platforms}</h5>
            </div>
          ))
        }
      </header>
    </div>
  );
}

export default App;
