import React, { useState } from "react";
import { useAuth } from "../../contexts/authContext.js";
import { useNavigate } from "react-router-dom";

import "./Login.css";

import "./Login.css";

function Login() {
  const { isLogin, setIsLogin } = useAuth();

  const navigate = useNavigate();
  const [isUsernameWrong, setIsUsernameWrong] = useState(false);
  const [isPasswordWrong, setIsPasswordWrong] = useState(false);

  // Dummy username and password
  const pwd = "1234";
  const usr = "admin";

  // Form data to store username and password
  const [formData, setFormData] = useState({
    username: "",
    password: "",
  });

  const toggleResetPW = () => {};

  const handleSubmit = (e) => {
    e.preventDefault();

    // Reset error messages
    setIsUsernameWrong(false);
    setIsPasswordWrong(false);

    // Check if username and password are correct
    //this have to implement with backend

    //dummy check
    if (formData.username === usr && formData.password === pwd) {
      setIsLogin(true);
      setFormData({ username: "", password: "" });
      navigate("/");
    } else if (formData.username !== usr) {
      setIsUsernameWrong(true);
      setFormData({ username: "", password: "" });
    } else if (formData.password !== pwd) {
      setIsPasswordWrong(true);
      setFormData({ password: "" });
    }
  };

  return (
    <div className="login-container">
      <div className="login-form-container">
        <h1>LOGIN</h1>
        <form className="login-form" onSubmit={handleSubmit}>
          <div className="input-container">
            <i class="bx bxs-user-circle"></i>
            <input
              type="text"
              placeholder="Username"
              value={formData.username}
              required
              onChange={(e) =>
                setFormData({ ...formData, username: e.target.value })
              }
            />
          </div>
          <div className="error-container">
            {isUsernameWrong ? (
              <p className="login-error-message">Username is invalid</p>
            ) : (
              <p className="login-error-message"></p>
            )}
          </div>
          <div className="input-container">
            <i class="bx bxs-lock"></i>
            <input
              type="password"
              placeholder="Password"
              value={formData.password}
              required
              onChange={(e) =>
                setFormData({ ...formData, password: e.target.value })
              }
            />
          </div>
          <div className="error-container">
            {isPasswordWrong ? (
              <p className="login-error-message">Password is invalid</p>
            ) : (
              <p></p>
            )}
          </div>
          <button className="login-btn" type="submit">
            Login
          </button>
        </form>
        <button className="reset-pw-btn" onClick={toggleResetPW}>
          Forgot Password ?
        </button>
        <p>
          Don't have an account ? <a href="/register"> Create Account</a>
        </p>
      </div>
    </div>
  );
}

export default Login;
