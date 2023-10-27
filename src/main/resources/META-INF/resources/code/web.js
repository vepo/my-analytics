function generateUUID() {
    let d = new Date().getTime(),
        d2 = ((typeof performance !== 'undefined') && performance.now && (performance.now() * 1000)) || 0;
    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, c => {
        let r = Math.random() * 16;
        if (d > 0) {
            r = (d + r) % 16 | 0;
            d = Math.floor(d / 16);
        } else {
            r = (d2 + r) % 16 | 0;
            d2 = Math.floor(d2 / 16);
        }
        return (c === 'x' ? r : (r & 0x7 | 0x8)).toString(16);
    });
}

function retrieveUserId() {
    let savedUserId = localStorage.getItem("user-id");
    if (savedUserId) {
        return savedUserId;
    }

    savedUserId = generateUUID();
    localStorage.setItem("user-id", savedUserId);
    return savedUserId;
}

(async function () {
    const contentUrl = new URL(window.location.href);
    console.log(contentUrl);
    console.log(`Initialize navigation! url=${contentUrl}`);
    const scriptUrl = new URL(document.currentScript.src);
    if (!scriptUrl.searchParams || !scriptUrl.searchParams.get("account-key")) {
        console.error(`No account defined! ${scriptUrl}`);
        return;
    }
    let accountKey = scriptUrl.searchParams.get("account-key");
    console.log(`Account defined: ${accountKey}`);
    const viewCreated = await fetch(scriptUrl.origin + '/view', {
            method: 'POST',
            mode: 'cors',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json; charset=UTF-8'
            },
            body: JSON.stringify({
                accountKey: accountKey,
                domain: contentUrl.host,
                path: contentUrl.pathname,
                userId: retrieveUserId()
            })
        })
            .then(response => console.log(`Respomse ${response.statusText}`))
            .catch(error => console.error(`ERROR: ${error}`))

    ;
})();
