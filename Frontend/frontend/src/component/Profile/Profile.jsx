import React from "react";
import { Route, Routes } from "react-router-dom";
import UserProfile from "./UserProfile";
import Address from "./Address";
import Favorites from "./Favorites";
import Event from "./Event";
import { ProfileNavigation } from "./ProfileNavigation";
import { Orders } from "./Orders";

const Profile = () => {
  return (
    <div className="lg:flex justify-between">
      <div className="sticky h-[80vh] lg:w-[20%] ">
        <ProfileNavigation />
      </div>
      <div className="lg:w-[80%]">
        <Routes>
          <Route path="/" element={<UserProfile />} />
          <Route path="orders" element={<Orders />} />
          <Route path="address" element={<Address />} />
          <Route path="favorites" element={<Favorites />} />
          <Route path="events" element={<Event />} />
        </Routes>
      </div>
    </div>
  );
};

export default Profile;
