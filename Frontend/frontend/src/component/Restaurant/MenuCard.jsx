import React from "react";
import Accordion from "@mui/material/Accordion";
import AccordionSummary from "@mui/material/AccordionSummary";
import AccordionDetails from "@mui/material/AccordionDetails";
import ExpandMoreIcon from "@mui/icons-material/ExpandMore";
import FormGroup from "@mui/material/FormGroup";
import FormControlLabel from "@mui/material/FormControlLabel";
import Checkbox from "@mui/material/Checkbox";
import { Button } from "@mui/material";

const demo = [
  {
    category: "nuts & seeds",
    ingredients: ["Cashews"],
  },

  {
    category: "Protien",
    ingredients: ["Ground beef", "bacon strips"],
  },
];

const MenuCard = () => {
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
              src="data:image/jpeg;base64,/9j/
                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"
              alt=""
            />
          </div>
          <div className="space-y-1 lg:space-y-5 lg:max-w-2xl">
            <p className="font font-semibold text-xl">Burger</p>
            <p>₹499</p>
            <p className="text-gray-400">
              A hamburger or siply burger is a food consisting of
              fillings-usually a patty of ground meat, typically beef--placed
              inside a slice bun or bread roll
            </p>
          </div>
        </div>
      </AccordionSummary>
      <AccordionDetails>
        <form>
          <div className="flex gap-5 flew-wrap ">
            {demo.map((item) => (
              <div>
                <p>{item.category}</p>
                <FormGroup>
                  {item.ingredients.map((item) => (
                    <FormControlLabel
                      control={<Checkbox onChange={()
                        =>handleCheckBoxChange(item)}/>}
                      label={item}
                    />
                  ))}
                </FormGroup>
              </div>
            ))}
          </div>
          <div className="pt-5">
            <Button variant="contained" disabled={false} type="submit">{true ? "Add to Cart" : "Out Of Stock"}</Button>
          </div>
        </form>
      </AccordionDetails>
    </Accordion>
  );
};

export default MenuCard;
