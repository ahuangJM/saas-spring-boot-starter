import React from "react";
import CSRF from "../contexts/HttpSecurityContext";

const LogoutButton: React.FC = () => {
    return <>
        <form action="/logout" method="POST">
            <input type="hidden" name="_csrf" value={CSRF.TOKEN!} />
            <input type="submit" value="Logout" />
        </form>
    </>;
}

export default LogoutButton;
