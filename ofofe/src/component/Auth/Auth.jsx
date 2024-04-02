import { Box, Modal } from "@mui/material";
import React from "react";
import { useLocation, useNavigate } from "react-router-dom";
import { style } from "../Cart/Cart";
import RegisterForm from "./RegisterForm";
import LoginForm from "./LoginForm";

const Auth = () => {
  const location = useLocation();
  const navigate = useNavigate();
  const handleClose = () => {
    navigate("/");
  };
  return (
    <>
      <Modal
        onClose={handleClose}
        open={
          location.pathname.includes("account/login") ||
          location.pathname.includes("account/register")
        }
      >
        <Box sx={style}>
          {location.pathname.includes("account/register") ? (
            <RegisterForm />
          ) : (
            <LoginForm />
          )}
        </Box>
      </Modal>
    </>
  );
};

export default Auth;
