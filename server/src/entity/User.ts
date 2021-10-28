import { Entity, Column, PrimaryGeneratedColumn } from "typeorm";

@Entity()
export class User {
    @PrimaryGeneratedColumn()
    id: number;

    @Column()
    username: string;

    @Column()
    email: string;

    @Column()
    password: string;

    @Column({ type: 'timestamptz', default: () => "CURRENT_TIMESTAMP" }) 
    last_seen: Date;

    @Column({ type: 'timestamptz', default: () => "CURRENT_TIMESTAMP" }) 
    register_date: Date;

    @Column({
        default: 0
    })
    total_seen_posts: number;
}