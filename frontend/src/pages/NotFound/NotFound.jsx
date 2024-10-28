import React from "react";
import Lottie from "react-lottie";
import notFoundAnimation from "../../lotties/404Error.json";
import { useNavigate } from "react-router-dom";

import "./NotFound.css";

function NotFound() {
  const navigate = useNavigate();

  return (
    <div className="not-found-container">
      <div className="not-found-text">Oops !</div>
      <div className="not-found-lottie">
        <Lottie
          options={{
            loop: true,
            autoplay: true,
            animationData: notFoundAnimation,
          }}
        />
      </div>
      <div className="not-found-text">Page Not Found</div>
      <div className="go-home-btn">
        <button onClick={() => navigate("/")}>GO HOME</button>
      </div>
    </div>
  );
}

export default NotFound;
