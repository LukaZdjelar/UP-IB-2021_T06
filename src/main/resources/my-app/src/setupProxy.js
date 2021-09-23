const {createProxyMiddleware } = require("http-proxy-middleware");

module.exports = app => {
  app.use(
    "/domZdravlja/*",
    createProxyMiddleware({
      target: "https://localhost:8080/klinickicentar/",
      changeOrigin: true
    })
  );
};