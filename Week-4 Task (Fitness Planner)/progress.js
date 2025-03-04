document.addEventListener("DOMContentLoaded", function () {
    console.log("Progress Tracker Loaded"); 

    const durationDisplay = document.getElementById("totalDuration");
    const daysDisplay = document.getElementById("totalDays");
    const clearBtn = document.getElementById("clearProgress");

    let totalDuration = parseInt(localStorage.getItem("totalDuration")) || 0;
    let totalDays = parseInt(localStorage.getItem("totalDays")) || 0;
    let workoutHistory = JSON.parse(localStorage.getItem("workoutHistory")) || [];

    console.log("Stored Data:", totalDuration, totalDays, workoutHistory);

    function updateDisplay() {
        durationDisplay.textContent = `${totalDuration} minutes`;
        daysDisplay.textContent = totalDays;
        updateGraph(workoutHistory);
    }

    function updateGraph(data) {
        const ctx = document.getElementById("progressChart").getContext("2d");

        if (window.myChart) {
            window.myChart.destroy(); 
        }

        window.myChart = new Chart(ctx, {
            type: "line",
            data: {
                labels: data.map((entry) => `Day ${entry.day}`),
                datasets: [
                    {
                        label: "Workout Duration (mins)",
                        data: data.map((entry) => entry.duration),
                        backgroundColor: "rgba(0, 90, 156, 0.5)",
                        borderColor: "#005A9C",
                        borderWidth: 2,
                        tension: 0.3,
                    },
                ],
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                scales: {
                    y: {
                        beginAtZero: true,
                    },
                },
            },
        });
    }

    clearBtn.addEventListener("click", function () {
        localStorage.setItem("totalDuration", "0");
        localStorage.setItem("totalDays", "0");
        localStorage.setItem("workoutHistory", JSON.stringify([]));
        totalDuration = 0;
        totalDays = 0;
        workoutHistory = [];
        updateDisplay();
    });

    updateDisplay();
});
