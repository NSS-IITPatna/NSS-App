package com.example.nss_iitpatna.ui.units

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.nss_iitpatna.R
import com.example.nss_iitpatna.ui.units.adhyayan.AdhyayanFragment
import com.example.nss_iitpatna.ui.units.chetna.ChetnaFragment
import com.example.nss_iitpatna.ui.units.environment.EnvironmentFragment
import com.example.nss_iitpatna.ui.units.prayatna.PrayatnaFragment
import com.example.nss_iitpatna.ui.units.rnd.RuralDevFragment

private val TAB_TITLES = arrayOf(
    R.string.tab_text_adhyayan,
    R.string.tab_text_chetna,
    R.string.tab_text_prayatna,
    R.string.tab_text_rural_dev,
    R.string.tab_text_environment
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return when (position) {
            0 -> AdhyayanFragment.newInstance()
            1 -> ChetnaFragment.newInstance()
            2 -> PrayatnaFragment.newInstance()
            3 -> RuralDevFragment.newInstance()
            else -> EnvironmentFragment.newInstance()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return 5
    }
}