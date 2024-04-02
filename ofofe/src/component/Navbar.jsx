import React from "react";
import SearchIcon from "@mui/icons-material/Search";
import { Avatar, Badge, IconButton } from "@mui/material";
import ShoppingCartIcon from "@mui/icons-material/ShoppingCart";
import "./Navbar.css";
import { Box } from "@mui/system";
import zIndex from "@mui/material/styles/zIndex";
import { Person } from "@mui/icons-material";
import { useNavigate } from "react-router-dom";

const Navbar = () => {
  const navigate = useNavigate();
  return (
    <Box
      sx={{ zIndex: 100 }}
      className="px-5 sticky top-0 x-50 py-[.8rem] bg-[#a21ee9] lg:px-20 flex justify-between"
    >
      <div className="flex items-center space-x-4">
        <div className="lg:mr-10 cursor-pointer flex items-center space-x-4">
          <li className="logo font-semibold text-grey-300 text-2xl">
            CALABAR KITCHEN
          </li>
        </div>
      </div>
      <div className="flex items-center space-x-2 lg:space-x-10">
        <div className="">
          <IconButton>
            <SearchIcon sx={{ fontSize: "1.5rem" }} />
          </IconButton>
        </div>
        <div className="">
          {false ? (
            <Avatar sx={{ bgcolor: "white" }}>C</Avatar>
          ) : (
            <IconButton onClick={() => navigate("/account/login")}>
              <Person />
            </IconButton>
          )}
        </div>
        <div className="">
          <IconButton>
            <Badge color="blue" badgeContent={3}>
              <ShoppingCartIcon sx={{ fontSize: "1.5rem" }} />
            </Badge>
          </IconButton>
        </div>
      </div>
    </Box>
  );
};

export default Navbar;
