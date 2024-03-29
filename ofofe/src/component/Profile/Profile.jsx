import React, { useState } from "react";
import ProfileNavigation from "./ProfileNavigation";
import { Route, Routes } from "react-router-dom";
import UserProfile from "./UserProfile";
import Orders from "./Orders";
import Address from "./Address";
import Event from "./Event";
import Favorite from "./Favorites";

const Profile = () => {
  const [openSideBar, setOpenSideBar] = useState(false);
  return (
    <div className="lg:flex items-center justify-center">
      <div className="sticky h-[80vh] lg:w-[20%]">
        <ProfileNavigation open={openSideBar} />
      </div>
      {/* <div className="lg:w-[80%]"></div> */}
      <Routes>
        <Route path="/" element={<UserProfile />} />
        <Route path="/orders" element={<Orders />} />
        <Route path="/address" element={<Address />} />
        <Route path="/favorites" element={<Favorite />} />
        <Route path="/events" element={<Event />} />
      </Routes>
    </div>
  );
};

export default Profile;
