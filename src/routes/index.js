const router = require("express").Router();
const task = require("../controllers/task");

router.get("/", (req, res) => {
  res.send("hola");
});

router.get("/allTasks", task.getAll);
router.post("/newTask", task.newTask);
router.delete("/delTask", task.deleteTask);

module.exports = router;
