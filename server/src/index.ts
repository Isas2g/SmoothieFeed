// Initialize env variables from .env config
import dotenv from "dotenv";
dotenv.config({ path: "./src/.env" });

import express, { Application } from "express";
import { connect } from "./database/db";
import { User } from "./entity/User";

const start = async () => {
  try {
    // Application port
    const PORT: number = parseInt(process.env.PORT!) || 3000;

    // Application
    const app: Application = express();

    // Connect to the database
    const orm = await connect();
    await orm.synchronize();

    const user = new User();
    user.username = 'test'
    user.email = 'test@mail.ru'
    user.password = '123'
    const rep = orm.getRepository(User)
    rep.create(user)

    console.log("Connected to the database.");

    app.listen(PORT, () => {
      console.log(`Server started on port ${PORT}.`);
    });
  } catch (error) {
    console.error(`[ERROR]: ${error.message}`);
  }
};

start();
