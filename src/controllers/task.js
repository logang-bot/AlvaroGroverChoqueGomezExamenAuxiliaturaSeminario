const ctrl = {};
const { model } = require("../models/task");
const task = require("../models/task");

ctrl.getAll = async (req, res) => {
  const tasks = await task.find({});
  res.send(tasks);
};

ctrl.newTask = async (req, res) => {
  const { title, description } = req.body;
  const errors = [];
  if (!title) {
    errors.push({ text: "please write a title" });
  }
  if (!description) {
    errors.push({ text: "please write a description" });
  }
  if (errors.length > 0) {
    res.send("the task is not valid");
  } else {
    const newTask = new task({ title, description });
    await newTask.save();
    res.send({ message: "the task was created succesfully" });
  }
};
ctrl.deleteTask = async (req, res) => {
  const id = req.query.id;
  await task.findByIdAndDelete(id);
  res.send({ message: "the task was deleted now" });
};

module.exports = ctrl;
