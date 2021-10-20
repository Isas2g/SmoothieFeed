// Initialize env variables from .env config
import dotenv from "dotenv";
dotenv.config({ path: "./src/.env" });

import express, { Application } from "express";
import { connect } from "./database/db";

const start = async () => {
  try {
    // Application port
    const PORT: number = parseInt(process.env.PORT!) || 3000;

    // Application
    const app: Application = express();

    // Connect to the database
    const orm = await connect();
    await orm.synchronize();

    console.log("Connected to the database.");

    app.listen(PORT, () => {
      console.log(`Server started on port ${PORT}.`);
    });
  } catch (error) {
    console.error(`[ERROR]: ${error.message}`);
  }
};

start();
