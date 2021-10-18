require("dotenv").config();

const express = require("express");
const db = require("./database/db");

const start = async () => {
  try {
    const app = express();

    const PORT = process.env.PORT || 3000;

    await db.authenticate();
    await db.sync();

    app.listen(PORT, () => {
      console.log("Connected to the database.");
      console.log(`Server started on port ${PORT}.`);
    });
  } catch (error) {
    console.error(`[ERROR]: ${error.message}`);
  }
};

start();
