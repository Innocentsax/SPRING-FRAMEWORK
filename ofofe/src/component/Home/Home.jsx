import React from "react";
import "./Home.css";

function Home() {
  return (
    <div>
      <section className="banner -z-50 relative flex flex-col justify-center items-center">
        <div className="w-[50vw] z-10 text-center">
          <p className="text-2xl lg:text-6xl font-bold z-10 py-5">
            CALABAR KITCHEN
          </p>
          <p className="z-10 text-grey-300 text-xl lg:text-4xl">
            Taste the Convenience: Food, Fast and Delivered
          </p>
        </div>
        <div className="cover absolute top-0 left-0 right-0"></div>
        <div className="fadout"></div>
      </section>
    </div>
  );
}

export default Home;
