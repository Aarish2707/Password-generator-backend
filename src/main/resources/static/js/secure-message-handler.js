// Secure message handler - lightweight version
(function() {
    'use strict';
    
    const ALLOWED_ORIGINS = [
        'https://password-generate-zvep.onrender.com',
        'http://localhost:3000',
        'http://localhost:8080'
    ];
    
    // Only intercept postMessage, not addEventListener to avoid React conflicts
    const originalPostMessage = window.postMessage;
    
    window.postMessage = function(message, targetOrigin, transfer) {
        if (targetOrigin === '*') {
            console.warn('Wildcard targetOrigin blocked for security');
            targetOrigin = window.location.origin;
        }
        
        return originalPostMessage.call(this, message, targetOrigin, transfer);
    };
    
})();