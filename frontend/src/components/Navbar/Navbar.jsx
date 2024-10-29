import React, { useState } from "react";
import "./Navbar.css";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../../contexts/authContext.js";

function Navbar() {
  const navigate = useNavigate();

  const [isCategoryOpen, setIsCategoryOpen] = useState(false);
  const [isThemeOpen, setIsThemeOpen] = useState(false);
  const [isMenuOpen, setIsMenuOpen] = useState(false);

  const { isLogin, setIsLogin } = useAuth();

  const toggleDropdown = () => {
    setIsCategoryOpen(!isCategoryOpen);
  };

  const toggleTheme = () => {
    setIsThemeOpen(!isThemeOpen);
  };

  const toggleMenu = () => {
    setIsMenuOpen(!isMenuOpen);
  };

  const handleLogOut = () => {
    setIsLogin(false);
    navigate("/");
  };

  const categories = [
    { id: 1, name: "Category 1" },
    { id: 2, name: "Category 2" },
    { id: 3, name: "Category 3" },
  ];

  const themes = ["theme 1", "theme 2", "theme 3"];

  return (
    <div className="navbar-container">
      <a href="/" className="logo">
        <img src={require("../../assets/images/logo.png")} alt="logo" />
        TasteHub
      </a>
      <nav className={`nav-bar ${isMenuOpen ? "active" : ""}`}>
        <div className="nav-bar-category">
          <button className="category-btn" onClick={toggleDropdown}>
            Categories <i className="bx bx-category"></i>
          </button>
          {isCategoryOpen && (
            <ul className="dropdown">
              {categories.map((category) => (
                <li key={category.id}>{category.name}</li>
              ))}
            </ul>
          )}
        </div>
        <div className="navbar-theme">
          <button className="theme-btn" onClick={toggleTheme}>
            Themes <i className="bx bx-brush-alt"></i>
          </button>
          {isThemeOpen && (
            <ul className="theme-dropdown">
              {themes.map((theme, index) => (
                <li key={index}>{theme}</li>
              ))}
            </ul>
          )}
        </div>
        {isLogin ? (
          <button className="log-btn" onClick={handleLogOut}>
            Log Out
          </button>
        ) : (
          <>
            <button className="log-btn" onClick={() => navigate("/login")}>
              Log In
            </button>
            <button
              className="register-btn"
              onClick={() => navigate("/register")}
            >
              Sign Up
            </button>
          </>
        )}
      </nav>
      <div className="navbar-menu" onClick={toggleMenu}>
        <i className={isMenuOpen ? "bx bx-x" : "bx bx-menu"} id="menu-logo"></i>
      </div>
    </div>
  );
}

export default Navbar;
