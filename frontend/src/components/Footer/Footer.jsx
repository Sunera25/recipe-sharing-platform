import React from "react";

import "./Footer.css";

function Footer() {
  return (
    <div className="footer-container">
      <div className="footer-details">
        <div className="about-us">
          <h3>About Us</h3>
          <p>
            At <strong>TasteHub</strong>, we believe great food brings people
            together. Our mission is to share easy, delicious recipes from
            around the world that inspire your kitchen adventures. Whether
            you’re an experienced chef or a beginner, our diverse collection
            offers something for everyone. Join us and discover new flavors and
            culinary delights that will make your cooking experience enjoyable
            and rewarding!
          </p>
        </div>
        <div className="contact-us">
          <h3>Contact Us</h3>
          <p>
            <i class="bx bxs-phone"></i> 011-2345678
          </p>
          <p>
            <i class="bx bxs-phone"></i> 011-4040404
          </p>
          <div className="social-media">
            <a href="https://www.facebook.com">
              <i class="bx bxl-facebook"></i>
            </a>
            <a href="https://www.twitter.com">
              <i class="bx bxl-twitter"></i>
            </a>
            <a href="https://www.instagram.com">
              <i class="bx bxl-instagram-alt"></i>
            </a>
            <a href="https://www.pinterest.com">
              <i class="bx bxl-pinterest"></i>
            </a>
          </div>
        </div>
      </div>
      <div className="footer-copyright">
        <p>© 2024 All rights reserved</p>
      </div>
    </div>
  );
}

export default Footer;
