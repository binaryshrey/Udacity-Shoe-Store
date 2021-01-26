package com.example.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.shoestore.databinding.ActivityMainBinding
import com.example.shoestore.viewmodel.ShoeViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private val viewModel: ShoeViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        //setting topLevelDestinations so as to hide up button from the list of below fragments
        val topLevelDestinations = mutableSetOf<Int>()
        topLevelDestinations.add(R.id.loginFragment)
        topLevelDestinations.add(R.id.introOnboardingFragment)
        topLevelDestinations.add(R.id.shoeListFragment)

        appBarConfiguration = AppBarConfiguration.Builder(topLevelDestinations).build()

        //setting up navController
        val navController = this.findNavController(R.id.navHostFragment)
        NavigationUI.setupActionBarWithNavController(this,navController, appBarConfiguration)

        viewModel.getLoginState(this)
        viewModel.isLoggedIn.observe(this,{isLoggedIn ->
//            if(isLoggedIn){
//                Navigation.findNavController(this, R.id.navHostFragment)
//                    .navigate(R.id.action_loginFragment_to_shoeListFragment)
//            }
            //getting current fragment
            val currentFragment = NavHostFragment.findNavController(navHostFragment).currentDestination?.id
            if(isLoggedIn){
                //various checks to avoid stacking up unwanted views and navigating accordingly
                if(currentFragment == R.id.loginFragment){
                    navController.popBackStack()
                    navController.navigate(R.id.shoeListFragment)
                }
                if(currentFragment == R.id.introOnboardingFragment){
                    navController.popBackStack()
                    navController.navigate(R.id.introOnboardingFragment)
                }
                if(currentFragment == R.id.outroOnboardingFragment){
                    navController.popBackStack()
                    navController.navigate(R.id.outroOnboardingFragment)
                }
            }
        })
        viewModel.isLoggedOut.observe(this, { isLoggedOut ->
            if (isLoggedOut) {
                navController.popBackStack()
                navController.navigate(R.id.loginFragment)
                viewModel.onLogOutComplete()
            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.navHostFragment)
        return navController.navigateUp()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.logout) {
            viewModel.onLogOut(this)
            viewModel.onLogOutComplete()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}