const mongoose = require('mongoose'):
const {Schema} = mongoose;

const taskSchema = new Schema({
    name:{
        type: String,
        required: true;
    },
    description:{
        type: String,
        required: true
    },
    date:{
        type: Date,
        default: Date.now
    }

})
module.exports = mongoose.model('task', taskSchema)