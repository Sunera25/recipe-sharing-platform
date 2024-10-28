import React from "react";
import { useAuth } from "../../contexts/authContext.js";

import "./Login.css";

function Login() {
  const { isLogin, setIsLogin } = useAuth();

  return <div>Login</div>;
}

export default Login;
