import React from "react";
import Lottie from "react-lottie";
import notFoundAnimation from "../../lotties/404Error.json";
import { useNavigate } from "react-router-dom";

import "./NotFound.css";

function NotFound() {
  const navigate = useNavigate();

  return (
    <div className="not-found-container">
      <h1 className="not-found-topic">Oops !</h1>
      <div className="not-found-lottie">
        <Lottie
          options={{
            loop: true,
            autoplay: true,
            animationData: notFoundAnimation,
          }}
        />
      </div>
      <h1 className="not-found-topic">Page Not Found</h1>
      <button className="go-home-btn" onClick={() => navigate("/")}>
        GO HOME
      </button>
    </div>
  );
}

export default NotFound;
