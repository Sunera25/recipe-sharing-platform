import React, { createContext, useContext, useState } from "react";

const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
  const [isLogin, setIsLogin] = useState(false);

  return (
    <AuthContext.Provider value={{ isLogin, setIsLogin }}>
      {children}
    </AuthContext.Provider>
  );
};

export const useAuth = () => useContext(AuthContext);
