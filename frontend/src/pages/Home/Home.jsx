import React from "react";
import Navbar from "../../components/Navbar/Navbar";

function Home() {
  // const [theme, setTheme] = useState("light");

  return (
    <div className="home-container">
      <Navbar />
      <h1>Home Page</h1>
      <p>Welcome to the Home Page</p>
    </div>
  );
}

export default Home;
