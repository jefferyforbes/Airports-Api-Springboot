// The Auth0 client, initialized in configureClient()
let auth0 = null;

/**
 * Starts the authentication flow
 */
const login = async (targetUrl) => {
  try {
    console.log("Logging in", targetUrl);

    const options = {
      redirect_uri: window.location.origin
    };

    if (targetUrl) {
      options.appState = { targetUrl };
    }

    await auth0.loginWithRedirect(options);
  } catch (err) {
    console.log("Log in failed", err);
  }
};

/**
 * Executes the logout flow
 */
const logout = () => {
  try {
    console.log("Logging out");
    auth0.logout({
      returnTo: window.location.origin
    });
  } catch (err) {
    console.log("Log out failed", err);
  }
};

/**
 * Retrieves the auth configuration from the server
 */
const fetchAuthConfig = () => fetch("/auth_config.json");

/**
 * Initializes the Auth0 client
 */
const configureClient = async () => {
  const response = await fetchAuthConfig();
  const config = await response.json();

  auth0 = await createAuth0Client({
    domain: config.domain,
    client_id: config.clientId,
    audience: config.audience
  });
};

const createBankAccount = async () => {

  try {
    const bodyReq = {
      "accountNumber": 76789,
      "passcode": 1234,
      "balance": 1000,
    }

    console.log("calling createBankAccount");
    const accessToken = await auth0.getTokenSilently();

    const res = await fetch("http://localhost:8080/banks", {
      method: 'POST',
      crossDomain: true,
      headers: {
        Authorization: `Bearer ${accessToken}`,
        "Content-Type": "application/json"
      },
      body: JSON.stringify(bodyReq)
    })
    const data = await res.json();
    console.log("response is:" + JSON.stringify(data));
  } catch (e) {
    console.log(e)
  }
}

const getAccount = async () => {
  try {

  } catch {

  }
}

const getBalance = async () => {
  try {

  } catch {

  }
}

const getStandingOrder = async () => {
  try {

  } catch {

  }
}

const createStandingOrder = async () => {
  try {

  } catch {

  }
}

const sendMoney = async () => {
  try {

  } catch {

  }
}

const callApi = async () => {
  try {
    console.log("calling api");
    // Get the access token from the Auth0 client
    const accessToken = await auth0.getTokenSilently();
    // const user = await auth0.getUser();
    // console.log('token is:' +accessToken);
    // console.log('user is:'+user);
    // Make the call to the API, setting the token
    // in the Authorization header
    const response = await fetch('http://localhost:8080/banks', {
      method: 'GET',
      crossDomain: true,
      headers: {
        Authorization: `Bearer ${accessToken}`
      }
    });
    // Fetch the JSON result
    const responseData = await response.json();
    console.log("response is:" + JSON.stringify(responseData));
    // TODO - hook up to UI
  } catch (e) {
    // Display errors in the console
    console.error(e);
  }
};

/**
 * Checks to see if the user is authenticated. If so, `fn` is executed. Otherwise, the user
 * is prompted to log in
 * @param {*} fn The function to execute if the user is logged in
 */
const requireAuth = async (fn, targetUrl) => {
  const isAuthenticated = await auth0.isAuthenticated();

  if (isAuthenticated) {
    return fn();
  }

  return login(targetUrl);
};

// Will run when page finishes loading
window.onload = async () => {
  await configureClient();

  // If unable to parse the history hash, default to the root URL
  if (!showContentFromUrl(window.location.pathname)) {
    showContentFromUrl("/");
    window.history.replaceState({ url: "/" }, {}, "/");
  }

  const bodyElement = document.getElementsByTagName("body")[0];

  // Listen out for clicks on any hyperlink that navigates to a #/ URL
  bodyElement.addEventListener("click", (e) => {
    if (isRouteLink(e.target)) {
      const url = e.target.getAttribute("href");

      if (showContentFromUrl(url)) {
        e.preventDefault();
        window.history.pushState({ url }, {}, url);
      }
    }
  });

  const isAuthenticated = await auth0.isAuthenticated();

  if (isAuthenticated) {
    console.log("> User is authenticated");
    window.history.replaceState({}, document.title, window.location.pathname);
    updateUI();
    return;
  }

  console.log("> User not authenticated");

  const query = window.location.search;
  const shouldParseResult = query.includes("code=") && query.includes("state=");

  if (shouldParseResult) {
    console.log("> Parsing redirect");
    try {
      const result = await auth0.handleRedirectCallback();

      if (result.appState && result.appState.targetUrl) {
        showContentFromUrl(result.appState.targetUrl);
      }

      console.log("Logged in!");
    } catch (err) {
      console.log("Error parsing redirect:", err);
    }

    window.history.replaceState({}, document.title, "/");
  }

  updateUI();
};
