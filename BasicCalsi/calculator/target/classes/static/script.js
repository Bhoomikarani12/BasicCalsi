function clearDisplay() {
    document.getElementById('displayone').value = '';
}

function appendToDisplay(value) {
    document.getElementById('displayone').value += value;
}

async function calculate() {
    const display = document.getElementById('displayone').value;
    try {
        // Send the expression to the backend for evaluation
        const response = await fetch(`/api/calculate?expression=${encodeURIComponent(display)}`);
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        const result = await response.text();

        // Display the result
        document.getElementById('displayone').value = result;

        // Fetch and update stats after calculation
        fetchStats();
    } catch (error) {
        console.error('Error:', error);
        document.getElementById('displayone').value = 'Error';
    }
}

async function fetchStats() {
    try {
        const response = await fetch('/api/stats');
        const stats = await response.text();
        document.getElementById('stats').innerText = stats;
    } catch (error) {
        console.error('Error:', error);
        document.getElementById('stats').innerText = 'Error loading stats';
    }
}

// Fetch stats initially when the page loads
window.onload = fetchStats;
