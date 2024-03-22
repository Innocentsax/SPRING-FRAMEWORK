import React from "react";
import ExpandMoreIcon from "@mui/icons-material/ExpandMore";
import Accordion from "@mui/material/Accordion";
import AccordionSummary from "@mui/material/AccordionSummary";
import AccordionDetails from "@mui/material/AccordionDetails";
import { Button, Checkbox, FormControlLabel, FormGroup } from "@mui/material";

const demo = [
  {
    category: "Nuts & seeds",
    ingredient: "Cashew",
  },
  {
    category: "Protein",
    ingredient: ["Ground beef", "Bacon Strips"],
  },
];

const MenuCard = () => {
  const handleCheckBoxChange = (value) => {
    console.log(value);
  };
  return (
    <Accordion>
      <AccordionSummary
        expandIcon={<ExpandMoreIcon />}
        aria-controls="panel1-content"
        id="panel1-header"
      >
        <div className="lg:flex items-center justify-between">
          <div className="lg:flex items-center lg:gap-5">
            <img
              className="w-[7rem] h-[7rem] object-cover"
              src="https://cdn.pixabay.com/photo/2018/07/10/21/23/pancake-3529653_1280.jpg"
              alt=""
            />
            <div className="space-y-1 lg:space-y-5 lg:max-w-2xl">
              <p className="font-semibold text-xl">Yummy</p>
              <p>₦3500</p>
              <p className="text-gray-400">
                A golden, fluffy stack of homemade pancakes, lightly crisped
                around the edges and tender through the center.
              </p>
            </div>
          </div>
        </div>
      </AccordionSummary>
      <AccordionDetails>
        <form>
          <div className="flex gap-5 flex-wrap">
            {demo.map((item, index) => (
              <div key={index}>
                <p>{item.category}</p>
                <FormGroup>
                  {Array.isArray(item.ingredient) ? (
                    item.ingredient.map((ingredient, idx) => (
                      <FormControlLabel
                        key={idx}
                        control={
                          <Checkbox
                            ocChange={() => handleCheckBoxChange(item)}
                          />
                        }
                        label={ingredient}
                      />
                    ))
                  ) : (
                    <FormControlLabel
                      control={<Checkbox />}
                      label={item.ingredient}
                    />
                  )}
                </FormGroup>
              </div>
            ))}
          </div>
          <div className="pt-5">
            <Button variant="contained" disabled={false} type="submit">
              {true ? "Add to cart" : "Out of stock"}
            </Button>
          </div>
        </form>
      </AccordionDetails>
    </Accordion>
  );
};

export default MenuCard;
