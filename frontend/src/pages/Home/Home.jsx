import React from "react";
import Navbar from "../../components/Navbar/Navbar";
import Footer from "../../components/Footer/Footer";

import "./Home.css";

function Home() {
  // const [theme, setTheme] = useState("light");

  return (
    <div className="home-container">
      <Navbar />
      <section className="home-section">
        <h1>Home Page</h1>
        <p>Welcome to the Home Page</p>
      </section>
      <Footer />
    </div>
  );
}

export default Home;
