const express = require("express");
const app = express();
const morgan = require("morgan");
const routes = require("../routes");
const path = require("path");

app.set("port", process.env.PORT || 8000);
app.use(morgan("dev"));

app.use("/public", express.static(path.join(__dirname, "../public")));

app.use(express.urlencoded({ extended: false }));

app.use("/", routes);

module.exports = app;
