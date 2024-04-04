package com.minipro.miniproject11

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.minipro.miniproject11.data.YourDataModel

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView
    private lateinit var userNameTextView: TextView
    private lateinit var userBranchTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard)

        drawerLayout = findViewById(R.id.drawerlayout)
        navView = findViewById(R.id.nav_view)

        // Set the header layout for NavigationView
        val headerView = navView.getHeaderView(0)
        userNameTextView = headerView.findViewById(R.id.txt_user_name)
        userBranchTextView = headerView.findViewById(R.id.txt_user_branch)

        // Set initial user data in the header
        setUserData()

        // Set listener for navigation item selection
        navView.setNavigationItemSelectedListener { menuItem ->
            onNavigationItemSelected(menuItem)
            true
        }

        // Setup the drawer button
        setupDrawerButton()
    }

    private fun setUserData() {
        // Fetch user data from YourDataModel
        val user = YourDataModel() // Replace with actual data retrieval
        userNameTextView.text = user.name ?: "Name Not Available"
        userBranchTextView.text = user.branch ?: "Branch Not Available"
        navView = findViewById(R.id.nav_view)
        navView.inflateMenu(R.menu.nav_menu)
    }

    private fun onNavigationItemSelected(menuItem: MenuItem) {
        when (menuItem.itemId) {
            R.id.nav_student_details -> {
                fetchStudentDetailsFromModel()
            }

            R.id.nav_progress_report -> {
                fetchProgressReportFromModel()
            }

            R.id.nav_attendance -> {
                fetchAttendanceFromModel()
            }
            // Handle other menu items as needed
            R.id.nav_logout -> {
                // Implement logout functionality if needed
            }
        }
        drawerLayout.closeDrawers() // Close the drawer after item selection
    }

    private fun fetchStudentDetailsFromModel() {
        val user = YourDataModel() // Replace with actual data retrieval
        setContentView(R.layout.student_details_layout)

        // Find the parent layout
        val studentDetailsLayout = findViewById<RelativeLayout>(R.id.student_details_layout)

        // Find the TextViews for student details
        val studentNameTextView = studentDetailsLayout.findViewById<TextView>(R.id.student_name)
        val studentBranchTextView = studentDetailsLayout.findViewById<TextView>(R.id.student_branch)
        val studentYearTextView = studentDetailsLayout.findViewById<TextView>(R.id.student_year)

        studentNameTextView.text = user.name
        studentBranchTextView.text = user.branch
        studentYearTextView.text = user.year

        // Go back button
        val goBackButton = studentDetailsLayout.findViewById<Button>(R.id.go_back_button)
        goBackButton.setOnClickListener {
            val intent = Intent(this@MainActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun fetchProgressReportFromModel() {
        val user = YourDataModel() // Replace with actual data retrieval

        setContentView(R.layout.progress_report_layout)

        // Find the parent layout
        val progressReportLayout = findViewById<RelativeLayout>(R.id.progress_report_layout)

        // Find the TextViews for progress report value, current semester marks, year, and attendance
        val progressReportTextView = progressReportLayout.findViewById<TextView>(R.id.progress_report_value)
        val currentSemMarksTextView = progressReportLayout.findViewById<TextView>(R.id.current_sem_marks)
        val currentSemYearTextView = progressReportLayout.findViewById<TextView>(R.id.current_sem_year)
        val currentSemAttendanceTextView = progressReportLayout.findViewById<TextView>(R.id.current_sem_attendance)
        val CurrentSemesterprogressTextView = findViewById<TextView>(R.id.progress_report_value)

        // Set data to the TextViews
        CurrentSemesterprogressTextView.text = user.progress
        currentSemMarksTextView.text = user.marks
        currentSemYearTextView.text = user.year
        currentSemAttendanceTextView.text = user.attendance

        // Go back button
        val goBackButton = progressReportLayout.findViewById<Button>(R.id.go_back_button)
        goBackButton.setOnClickListener {
            val intent = Intent(this@MainActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun fetchAttendanceFromModel() {
        val user = YourDataModel() // Replace with actual data retrieval
        setContentView(R.layout.attendance_layout)

        // Find the parent layout
        val attendanceLayout = findViewById<RelativeLayout>(R.id.attendance_layout)

        // Find the TextView for attendance value
        val attendanceTextView = attendanceLayout.findViewById<TextView>(R.id.attendance_value)
        attendanceTextView.text = user.attendance

        // Go back button
        val goBackButton = attendanceLayout.findViewById<Button>(R.id.go_back_button)
        goBackButton.setOnClickListener {
            val intent = Intent(this@MainActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }



    private fun setupDrawerButton() {
        // Set up the button to open the navigation drawer
        val openDrawerButton: ImageButton = findViewById(R.id.open_drawer_button)
        openDrawerButton.setOnClickListener {
            if (drawerLayout.isDrawerOpen(navView)) {
                drawerLayout.closeDrawer(navView)
            } else {
                drawerLayout.openDrawer(navView)
            }
        }
    }
}