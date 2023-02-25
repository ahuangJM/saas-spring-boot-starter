import React from "react";
import CSRF from "../contexts/HttpSecurityContext";

const Login: React.FC = () => {
    return <>
        <form action="/login" method="post">
            <div>
                <input type="text" name="username" placeholder="Username"/>
            </div>
            <div>
                <input type="password" name="password" placeholder="Password"/>
            </div>
            <input type="hidden" name="_csrf" value={CSRF.TOKEN!} />
            <input type="submit" value="Log in" />
        </form>
    </>;
}

export default Login;
