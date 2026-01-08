// Karma configuration file
// This tells Karma (the test runner) how to run your Angular tests
// It uses Jasmine as the test framework and runs tests in Chrome browser

module.exports = function(config) {
  config.set({
    // Base path that will be used to resolve all patterns (e.g., files, exclude)
    basePath: '',
    
    // Testing framework to use (Jasmine is Angular's default)
    frameworks: ['jasmine', '@angular-devkit/build-angular'],
    
    // Plugins required for Karma to work with Angular + Jasmine
    plugins: [
      require('karma-jasmine'),
      require('karma-chrome-launcher'),
      require('karma-jasmine-html-reporter'),
      require('karma-coverage'),
      require('@angular-devkit/build-angular/plugins/karma')
    ],
    
    // Configuration for the Angular build system
    client: {
      jasmine: {
        // Jasmine configuration options
      },
      // Clear the terminal before each test run
      clearContext: false
    },
    
    // Where to write test coverage reports
    jasmineHtmlReporter: {
      suppressAll: true
    },
    
    // Code coverage reporter configuration
    coverageReporter: {
      dir: require('path').join(__dirname, './coverage'),
      subdir: '.',
      reporters: [
        { type: 'html' },      // HTML report for viewing in browser
        { type: 'text-summary' }, // Summary in terminal
        { type: 'lcovonly' }   // For CI/CD tools
      ]
    },
    
    // Test results reporter to use
    // 'progress' shows dots as tests run, 'kjhtml' shows results in browser
    reporters: ['progress', 'kjhtml'],
    
    // Web server port
    port: 9876,
    
    // Enable/disable colors in the output
    colors: true,
    
    // Level of logging (config.LOG_DISABLE, LOG_ERROR, LOG_WARN, LOG_INFO, LOG_DEBUG)
    logLevel: config.LOG_INFO,
    
    // Enable/disable watching file and executing tests whenever any file changes
    autoWatch: true,
    
    // Browser to use for testing
    // 'Chrome' for regular Chrome, 'ChromeHeadless' for CI/CD (no GUI)
    browsers: ['Chrome'],
    
    // Continuous Integration mode
    // If true, Karma captures browsers, runs tests, and exits
    singleRun: false,
    
    // How long to wait (in ms) before disconnecting browser
    restartOnFileChange: true
  });
};
