"use strict";
const mongoose = require("mongoose");

mongoose
  .connect("mongodb://172.22.0.2:27017/envirodb", {
    useCreateIndex: true,
    useNewUrlParser: true,
    useFindAndModify: true,
  })
  .then((db) => console.log("DB Working!"))
  .catch((err) => console.error(err));
