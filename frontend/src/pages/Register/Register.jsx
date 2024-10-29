import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

import "./Register.css";

function Register() {
  const navigate = useNavigate();

  const [checked, setChecked] = useState(false);
  const [isPasswordMatch, setIsPasswordMatch] = useState(true);

  const [formData, setFormData] = useState({
    fName: "",
    lName: "",
    email: "",
    phone: "",
    username: "",
    password: "",
    confirmPassword: "",
  });

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(formData);

    if (formData.password !== formData.confirmPassword) {
      setIsPasswordMatch(false);
      return;
    }

    navigate("/login");

    //I have to implent this later
  };

  return (
    <div className="register-container">
      <div className="register-form-container">
        <h1>Register</h1>
        <form className="register-form" onSubmit={handleSubmit}>
          <div className="register-form-raw">
            <div className="register-form-input">
              <i className="bx bxs-user-circle"></i>
              <input
                type="text"
                placeholder="Enter Your First Name"
                value={formData.fName}
                onChange={(e) =>
                  setFormData({ ...formData, fName: e.target.value })
                }
                required
              />
            </div>
            <div className="register-form-input">
              <i className="bx bxs-user-circle"></i>
              <input
                type="text"
                placeholder="Enter Your Last Name"
                value={formData.lName}
                onChange={(e) =>
                  setFormData({ ...formData, lName: e.target.value })
                }
                required
              />
            </div>
          </div>
          <div className="register-form-raw">
            <div className="register-form-input">
              <i className="bx bxs-phone"></i>
              <input
                type="text"
                placeholder="Enter Your Phone Number"
                value={formData.phone}
                onChange={(e) =>
                  setFormData({ ...formData, phone: e.target.value })
                }
                required
              />
            </div>
            <div className="register-form-input">
              <i className="bx bxs-user-circle"></i>
              <input
                type="text"
                placeholder="Enter Your Username"
                value={formData.username}
                onChange={(e) =>
                  setFormData({ ...formData, username: e.target.value })
                }
                required
              />
            </div>
          </div>
          <div className="register-form-raw">
            <div className="register-form-input">
              <i className="bx bxs-lock-alt"></i>
              <input
                type="password"
                placeholder="Enter Your Password"
                value={formData.password}
                onChange={(e) =>
                  setFormData({ ...formData, password: e.target.value })
                }
                required
              />
            </div>
            <div className="register-form-input">
              <i className="bx bxs-lock-alt"></i>
              <input
                type="password"
                placeholder="Confirm Your Password"
                value={formData.confirmPassword}
                onChange={(e) =>
                  setFormData({ ...formData, confirmPassword: e.target.value })
                }
                required
              />
            </div>
          </div>
          <div className="register-form-raw">
            <div className="register-form-email">
              <i class="bx bxs-envelope"></i>
              <input
                type="email"
                placeholder="Enter Your Email"
                value={formData.email}
                onChange={(e) =>
                  setFormData({ ...formData, email: e.target.value })
                }
                required
              />
            </div>
          </div>
          <div className="register-form-checkbox">
            <input type="checkbox" onChange={(e) => setChecked(!checked)} />
            <label> I agree to the terms and conditions</label>
          </div>
          <button
            className="register-form-button"
            type="submit"
            disabled={!checked}
          >
            Register
          </button>
        </form>
        <div className="login-link">
          <p>Already have an account? Click here to </p>
          <a href="/login">Log In</a>
        </div>
      </div>
    </div>
  );
}

export default Register;
