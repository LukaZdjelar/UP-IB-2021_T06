const {createProxyMiddleware } = require("http-proxy-middleware");

module.exports = app => {
  app.use(
    "/klinickicentar/*",
    createProxyMiddleware({
      target: "http://localhost:8080",
      changeOrigin: true
    })
  );
};