const CSRF = {
    TOKEN: document.head.querySelector('meta[name="_csrf"]')!.getAttribute("content"),
    HEADER: document.head.querySelector('meta[name="_csrf_header"]')!.getAttribute("content"),
}

export default CSRF;
