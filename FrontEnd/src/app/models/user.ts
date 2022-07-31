export class User {
    constructor(user: User) {
        this.role = user.role;
    }

    role: string;
}