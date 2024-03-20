import React from "react";

const Navbar = () => {
  return (
    <div className="px-5 x-50 py-[.8rem] bg-[#e91e63] lg:px-20 flex justify-between">
      <div className="flex items-center space-x-4">
        <div className="lg:mr-10 cursor-pointer flex items-center space-x-4">
          <li className="logo font-semibold text-grey-300 text-2x1">
            Calabar Kitchen
          </li>
        </div>
      </div>
    </div>
  );
};

export default Navbar;
