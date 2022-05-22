package com.example.mealplanner.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.DialogFragment
import com.example.mealplanner.R
import com.example.mealplanner.data.models.*

class AddWeekDialogFragment(
    private val mealList: List<Meal>,
    private val homeViewModel: HomeViewModel
) : DialogFragment() {
    private lateinit var spinnerMonday1: Spinner
    private lateinit var spinnerMonday2: Spinner
    private lateinit var spinnerMonday3: Spinner
    private lateinit var spinnerTuesday1: Spinner
    private lateinit var spinnerTuesday2: Spinner
    private lateinit var spinnerTuesday3: Spinner
    private lateinit var spinnerWednesday1: Spinner
    private lateinit var spinnerWednesday2: Spinner
    private lateinit var spinnerWednesday3: Spinner
    private lateinit var spinnerThursday1: Spinner
    private lateinit var spinnerThursday2: Spinner
    private lateinit var spinnerThursday3: Spinner
    private lateinit var spinnerFriday1: Spinner
    private lateinit var spinnerFriday2: Spinner
    private lateinit var spinnerFriday3: Spinner
    private lateinit var spinnerSaturday1: Spinner
    private lateinit var spinnerSaturday2: Spinner
    private lateinit var spinnerSaturday3: Spinner
    private lateinit var spinnerSunday1: Spinner
    private lateinit var spinnerSunday2: Spinner
    private lateinit var spinnerSunday3: Spinner
    private lateinit var btnAddWeek: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_week_dialog_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var freshMondayId: Long = 0
        var freshTuesdayId: Long = 0
        var freshWednesdayId: Long = 0
        var freshThursdayId: Long = 0
        var freshFridayId: Long = 0
        var freshSaturdayId: Long = 0
        var freshSundayId: Long = 0
        var freshWeekId: Long = 0

        val mondayList = mutableListOf<MondayMealCrossRef>()
        val tuesdayList = mutableListOf<TuesdayMealCrossRef>()
        val wednesdayList = mutableListOf<WednesdayMealCrossRef>()
        val thursdayList = mutableListOf<ThursdayMealCrossRef>()
        val fridayList = mutableListOf<FridayMealCrossRef>()
        val saturdayList = mutableListOf<SaturdayMealCrossRef>()
        val sundayList = mutableListOf<SundayMealCrossRef>()

        spinnerMonday1 = view.findViewById(R.id.spinnerMealsMonday1)
        spinnerMonday2 = view.findViewById(R.id.spinnerMealsMonday2)
        spinnerMonday3 = view.findViewById(R.id.spinnerMealsMonday3)
        spinnerTuesday1 = view.findViewById(R.id.spinnerMealsTuesday1)
        spinnerTuesday2 = view.findViewById(R.id.spinnerMealsTuesday2)
        spinnerTuesday3 = view.findViewById(R.id.spinnerMealsTuesday3)
        spinnerWednesday1 = view.findViewById(R.id.spinnerMealsWednesday1)
        spinnerWednesday2 = view.findViewById(R.id.spinnerMealsWednesday2)
        spinnerWednesday3 = view.findViewById(R.id.spinnerMealsWednesday3)
        spinnerThursday1 = view.findViewById(R.id.spinnerMealsThursday1)
        spinnerThursday2 = view.findViewById(R.id.spinnerMealsThursday2)
        spinnerThursday3 = view.findViewById(R.id.spinnerMealsThursday3)
        spinnerFriday1 = view.findViewById(R.id.spinnerMealsFriday1)
        spinnerFriday2 = view.findViewById(R.id.spinnerMealsFriday2)
        spinnerFriday3 = view.findViewById(R.id.spinnerMealsFriday3)
        spinnerSaturday1 = view.findViewById(R.id.spinnerMealsSaturday1)
        spinnerSaturday2 = view.findViewById(R.id.spinnerMealsSaturday2)
        spinnerSaturday3 = view.findViewById(R.id.spinnerMealsSaturday3)
        spinnerSunday1 = view.findViewById(R.id.spinnerMealsSunday1)
        spinnerSunday2 = view.findViewById(R.id.spinnerMealsSunday2)
        spinnerSunday3 = view.findViewById(R.id.spinnerMealsSunday3)
        btnAddWeek = view.findViewById(R.id.buttonAddWeek)

        val mealListBase = mutableListOf<Meal>()
        mealListBase.add(Meal("",999))
        mealListBase.addAll(mealList)

        val mealListMonday2 = mutableListOf<Meal>()
        val mealListMonday3 = mutableListOf<Meal>()
        val adapterMealListMonday1 = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, mealListBase)
        val adapterMealListMonday2 = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, mealListMonday2)
        val adapterMealListMonday3 = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, mealListMonday3)

        val mealListTuesday2 = mutableListOf<Meal>()
        val mealListTuesday3 = mutableListOf<Meal>()
        val adapterMealListTuesday1 = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, mealListBase)
        val adapterMealListTuesday2 = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, mealListTuesday2)
        val adapterMealListTuesday3 = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, mealListTuesday3)

        val mealListWednesday2 = mutableListOf<Meal>()
        val mealListWednesday3 = mutableListOf<Meal>()
        val adapterMealListWednesday1 = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, mealListBase)
        val adapterMealListWednesday2 = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, mealListWednesday2)
        val adapterMealListWednesday3 = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, mealListWednesday3)

        val mealListThursday2 = mutableListOf<Meal>()
        val mealListThursday3 = mutableListOf<Meal>()
        val adapterMealListThursday1 = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, mealListBase)
        val adapterMealListThursday2 = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, mealListThursday2)
        val adapterMealListThursday3 = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, mealListThursday3)

        val mealListFriday2 = mutableListOf<Meal>()
        val mealListFriday3 = mutableListOf<Meal>()
        val adapterMealListFriday1 = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, mealListBase)
        val adapterMealListFriday2 = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, mealListFriday2)
        val adapterMealListFriday3 = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, mealListFriday3)

        val mealListSaturday2 = mutableListOf<Meal>()
        val mealListSaturday3 = mutableListOf<Meal>()
        val adapterMealListSaturday1 = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, mealListBase)
        val adapterMealListSaturday2 = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, mealListSaturday2)
        val adapterMealListSaturday3 = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, mealListSaturday3)

        val mealListSunday2 = mutableListOf<Meal>()
        val mealListSunday3 = mutableListOf<Meal>()
        val adapterMealListSunday1 = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, mealListBase)
        val adapterMealListSunday2 = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, mealListSunday2)
        val adapterMealListSunday3 = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, mealListSunday3)

        spinnerMonday1.adapter = adapterMealListMonday1
        spinnerMonday2.adapter = adapterMealListMonday2
        spinnerMonday3.adapter = adapterMealListMonday3
        spinnerTuesday1.adapter = adapterMealListTuesday1
        spinnerTuesday2.adapter = adapterMealListTuesday2
        spinnerTuesday3.adapter = adapterMealListTuesday3
        spinnerWednesday1.adapter = adapterMealListWednesday1
        spinnerWednesday2.adapter = adapterMealListWednesday2
        spinnerWednesday3.adapter = adapterMealListWednesday3
        spinnerThursday1.adapter = adapterMealListThursday1
        spinnerThursday2.adapter = adapterMealListThursday2
        spinnerThursday3.adapter = adapterMealListThursday3
        spinnerFriday1.adapter = adapterMealListFriday1
        spinnerFriday2.adapter = adapterMealListFriday2
        spinnerFriday3.adapter = adapterMealListFriday3
        spinnerSaturday1.adapter = adapterMealListSaturday1
        spinnerSaturday2.adapter = adapterMealListSaturday2
        spinnerSaturday3.adapter = adapterMealListSaturday3
        spinnerSunday1.adapter = adapterMealListSunday1
        spinnerSunday2.adapter = adapterMealListSunday2
        spinnerSunday3.adapter = adapterMealListSunday3

        val spinnersPositionCheck = MutableList(21) { false }
        var currentSelectedItem: Meal

        fun changeNextAdapter(position: Int, previousAdapter:ArrayAdapter<Meal> , nextAdapter:  ArrayAdapter<Meal>, previousList: MutableList<Meal>){
            currentSelectedItem = previousAdapter.getItem(position)!!
            nextAdapter.clear()
            nextAdapter.addAll(previousList)
            nextAdapter.remove(currentSelectedItem)
        }
        spinnerMonday1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?, position: Int, id: Long) {
              if (position != 0){
                  spinnersPositionCheck[0] = true
                    if (mondayList.size == 1){
                        mondayList.removeAt(0)
                    }
                  mondayList.add(MondayMealCrossRef(freshMondayId, (parentView!!.selectedItem as Meal).mealId))
                  changeNextAdapter(position, adapterMealListMonday1, adapterMealListMonday2, mealListBase)
                  spinnerMonday2.isEnabled = true
              }else{
                  spinnersPositionCheck[0] = false
              }
            }
            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
        spinnerMonday2.isEnabled = false
        spinnerMonday2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?, position: Int, id: Long) {
                if (position != 0){
                    spinnersPositionCheck[1] = true
                    if (mondayList.size == 2) {
                        mondayList.removeAt(1)
                    }
                    mondayList.add(MondayMealCrossRef(freshMondayId, (parentView!!.selectedItem as Meal).mealId))
                    changeNextAdapter(position, adapterMealListMonday2,adapterMealListMonday3, mealListMonday2)
                    spinnerMonday3.isEnabled = true
                }else{
                    spinnersPositionCheck[1] = false
                }
            }
            override fun onNothingSelected(parentView: AdapterView<*>?) {
            }
        }
        spinnerMonday3.isEnabled = false
        spinnerMonday3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?, position: Int, id: Long) {
                if (position != 0){
                    spinnersPositionCheck[2] = true
                    if (mondayList.size == 3) {
                        mondayList.removeAt(2)
                    }
                    mondayList.add(MondayMealCrossRef(freshMondayId, (parentView!!.selectedItem as Meal).mealId))
                    spinnerTuesday1.isEnabled = true
                }else{
                    spinnersPositionCheck[2] = false
                }
            }
            override fun onNothingSelected(parentView: AdapterView<*>?) {
            }
        }
        spinnerTuesday1.isEnabled = false
        spinnerTuesday1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?, position: Int, id: Long) {
                if (position != 0){
                    spinnersPositionCheck[3] = true
                    if (tuesdayList.size == 1) {
                        tuesdayList.removeAt(0)
                    }
                    tuesdayList.add(TuesdayMealCrossRef(freshTuesdayId, (parentView!!.selectedItem as Meal).mealId))
                    changeNextAdapter(position, adapterMealListTuesday1, adapterMealListTuesday2, mealListBase)
                    spinnerTuesday2.isEnabled = true
                }else{
                    spinnersPositionCheck[3] = false
                }
            }
            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
        spinnerTuesday2.isEnabled = false
        spinnerTuesday2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?, position: Int, id: Long) {
                if (position != 0){
                    spinnersPositionCheck[4] = true
                    if (tuesdayList.size == 2) {
                        tuesdayList.removeAt(1)
                    }
                    tuesdayList.add(TuesdayMealCrossRef(freshTuesdayId, (parentView!!.selectedItem as Meal).mealId))
                    changeNextAdapter(position, adapterMealListTuesday2, adapterMealListTuesday3, mealListTuesday2)
                    spinnerTuesday3.isEnabled = true
                }else{
                    spinnersPositionCheck[4] = false
                }
            }
            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
        spinnerTuesday3.isEnabled = false
        spinnerTuesday3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?, position: Int, id: Long) {
                if (position != 0){
                    spinnersPositionCheck[5] = true
                    if (tuesdayList.size == 3) {
                        tuesdayList.removeAt(2)
                    }
                    tuesdayList.add(TuesdayMealCrossRef(freshTuesdayId, (parentView!!.selectedItem as Meal).mealId))
                    spinnerWednesday1.isEnabled = true
                }else{
                    spinnersPositionCheck[5] = false
                }
            }
            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
        spinnerWednesday1.isEnabled = false
        spinnerWednesday1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?, position: Int, id: Long) {
                if (position != 0){
                    spinnersPositionCheck[6] = true
                    if (wednesdayList.size == 1) {
                        wednesdayList.removeAt(0)
                    }
                    wednesdayList.add(WednesdayMealCrossRef(freshWednesdayId, (parentView!!.selectedItem as Meal).mealId))
                    changeNextAdapter(position, adapterMealListWednesday1, adapterMealListWednesday2, mealListBase)
                    spinnerWednesday2.isEnabled = true
                }else{
                    spinnersPositionCheck[6] = false
                }
            }
            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
        spinnerWednesday2.isEnabled = false
        spinnerWednesday2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?, position: Int, id: Long) {
                if (position != 0){
                    spinnersPositionCheck[7] = true
                    if (wednesdayList.size == 2) {
                        wednesdayList.removeAt(1)
                    }
                    wednesdayList.add(WednesdayMealCrossRef(freshWednesdayId, (parentView!!.selectedItem as Meal).mealId))
                    changeNextAdapter(position, adapterMealListWednesday2, adapterMealListWednesday3, mealListWednesday2)
                    spinnerWednesday3.isEnabled = true
                }else{
                    spinnersPositionCheck[7] = false
                }
            }
            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
        spinnerWednesday3.isEnabled = false
        spinnerWednesday3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?, position: Int, id: Long) {
                if (position != 0){
                    spinnersPositionCheck[8] = true
                    if (wednesdayList.size == 3) {
                        wednesdayList.removeAt(2)
                    }
                    wednesdayList.add(WednesdayMealCrossRef(freshWednesdayId, (parentView!!.selectedItem as Meal).mealId))
                    spinnerThursday1.isEnabled = true
                }else{
                    spinnersPositionCheck[8] = false
                }
            }
            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
        spinnerThursday1.isEnabled = false
        spinnerThursday1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?, position: Int, id: Long) {
                if (position != 0){
                    spinnersPositionCheck[9] = true
                    if (thursdayList.size == 1) {
                        thursdayList.removeAt(0)
                    }
                    thursdayList.add(ThursdayMealCrossRef(freshThursdayId, (parentView!!.selectedItem as Meal).mealId))
                    changeNextAdapter(position, adapterMealListThursday1, adapterMealListThursday2, mealListBase)
                    spinnerThursday2.isEnabled = true
                }else{
                    spinnersPositionCheck[9] = false
                }
            }
            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
        spinnerThursday2.isEnabled = false
        spinnerThursday2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?, position: Int, id: Long) {
                if (position != 0){
                    spinnersPositionCheck[10] = true
                    if (thursdayList.size == 2) {
                        thursdayList.removeAt(1)
                    }
                    thursdayList.add(ThursdayMealCrossRef(freshThursdayId, (parentView!!.selectedItem as Meal).mealId))
                    changeNextAdapter(position, adapterMealListThursday2, adapterMealListThursday3, mealListThursday2)
                    spinnerThursday3.isEnabled = true
                }else{
                    spinnersPositionCheck[10] = false
                }
            }
            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
        spinnerThursday3.isEnabled = false
        spinnerThursday3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?, position: Int, id: Long) {
                if (position != 0){
                    spinnersPositionCheck[11] = true
                    if (thursdayList.size == 3) {
                        thursdayList.removeAt(2)
                    }
                    thursdayList.add(ThursdayMealCrossRef(freshThursdayId, (parentView!!.selectedItem as Meal).mealId))
                    spinnerFriday1.isEnabled = true
                }else{
                    spinnersPositionCheck[11] = false
                }
            }
            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
        spinnerFriday1.isEnabled = false
        spinnerFriday1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?, position: Int, id: Long) {
                if (position != 0){
                    spinnersPositionCheck[12] = true
                    if (fridayList.size == 1) {
                        fridayList.removeAt(0)
                    }
                    fridayList.add(FridayMealCrossRef(freshFridayId, (parentView!!.selectedItem as Meal).mealId))
                    changeNextAdapter(position, adapterMealListFriday1, adapterMealListFriday2, mealListBase)
                    spinnerFriday2.isEnabled = true
                }else{
                    spinnersPositionCheck[12] = false
                }
            }
            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
        spinnerFriday2.isEnabled = false
        spinnerFriday2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?, position: Int, id: Long) {
                if (position != 0){
                    spinnersPositionCheck[13] = true
                    if (fridayList.size == 2) {
                        fridayList.removeAt(1)
                    }
                    fridayList.add(FridayMealCrossRef(freshFridayId, (parentView!!.selectedItem as Meal).mealId))
                    changeNextAdapter(position, adapterMealListFriday2, adapterMealListFriday3, mealListFriday2)
                    spinnerFriday3.isEnabled = true
                }else{
                    spinnersPositionCheck[13] = false
                }
            }
            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
        spinnerFriday3.isEnabled = false
        spinnerFriday3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?, position: Int, id: Long) {
                if (position != 0){
                    spinnersPositionCheck[14] = true
                    if (fridayList.size == 3) {
                        fridayList.removeAt(2)
                    }
                    fridayList.add(FridayMealCrossRef(freshFridayId, (parentView!!.selectedItem as Meal).mealId))
                    spinnerSaturday1.isEnabled = true
                }else{
                    spinnersPositionCheck[14] = false
                }
            }
            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
        spinnerSaturday1.isEnabled = false
        spinnerSaturday1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?, position: Int, id: Long) {
                if (position != 0){
                    spinnersPositionCheck[15] = true
                    if (saturdayList.size == 1) {
                        saturdayList.removeAt(0)
                    }
                    saturdayList.add(SaturdayMealCrossRef(freshSaturdayId, (parentView!!.selectedItem as Meal).mealId))
                    changeNextAdapter(position, adapterMealListSaturday1, adapterMealListSaturday2, mealListBase)
                    spinnerSaturday2.isEnabled = true
                }else{
                    spinnersPositionCheck[15] = false
                }
            }
            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
        spinnerSaturday2.isEnabled = false
        spinnerSaturday2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?, position: Int, id: Long) {
                if (position != 0){
                    spinnersPositionCheck[16] = true
                    if (saturdayList.size == 2) {
                        saturdayList.removeAt(1)
                    }
                    saturdayList.add(SaturdayMealCrossRef(freshSaturdayId, (parentView!!.selectedItem as Meal).mealId))
                    changeNextAdapter(position, adapterMealListSaturday2, adapterMealListSaturday3, mealListSaturday2)
                    spinnerSaturday3.isEnabled = true
                }else{
                    spinnersPositionCheck[16] = false
                }
            }
            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
        spinnerSaturday3.isEnabled = false
        spinnerSaturday3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?, position: Int, id: Long) {
                if (position != 0){
                    spinnersPositionCheck[17] = true
                    if (saturdayList.size == 3) {
                        saturdayList.removeAt(2)
                    }
                    saturdayList.add(SaturdayMealCrossRef(freshSaturdayId, (parentView!!.selectedItem as Meal).mealId))
                    spinnerSunday1.isEnabled = true
                }else{
                    spinnersPositionCheck[17] = false
                }
            }
            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
        spinnerSunday1.isEnabled = false
        spinnerSunday1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?, position: Int, id: Long) {
                if (position != 0){
                    spinnersPositionCheck[18] = true
                    if (sundayList.size == 1) {
                        sundayList.removeAt(0)
                    }
                    sundayList.add(SundayMealCrossRef(freshSundayId, (parentView!!.selectedItem as Meal).mealId))
                    changeNextAdapter(position, adapterMealListSaturday1, adapterMealListSunday2, mealListBase)
                    spinnerSunday2.isEnabled = true
                }else{
                    spinnersPositionCheck[18] = false
                }
            }
            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
        spinnerSunday2.isEnabled = false
        spinnerSunday2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?, position: Int, id: Long) {
                if (position != 0){
                    spinnersPositionCheck[19] = true
                    if (sundayList.size == 2) {
                        sundayList.removeAt(1)
                    }
                    sundayList.add(SundayMealCrossRef(freshSundayId, (parentView!!.selectedItem as Meal).mealId))
                    changeNextAdapter(position, adapterMealListSunday2, adapterMealListSunday3, mealListSunday2)
                    spinnerSunday3.isEnabled = true
                }else{
                    spinnersPositionCheck[19] = false
                }
            }
            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
        spinnerSunday3.isEnabled = false
        spinnerSunday3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?, position: Int, id: Long) {
                if (position != 0){
                    spinnersPositionCheck[20] = true
                    if (sundayList.size == 3) {
                        sundayList.removeAt(2)
                    }
                    sundayList.add(SundayMealCrossRef(freshSundayId, (parentView!!.selectedItem as Meal).mealId))
                }else{
                    spinnersPositionCheck[20] = false
                }
            }
            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }

        btnAddWeek.setOnClickListener{
            if (spinnersPositionCheck.all { it }){
                homeViewModel.insertDayweeks(Monday(freshMondayId), Tuesday(freshTuesdayId), Wednesday(freshWednesdayId), Thursday(freshThursdayId),
                    Friday(freshFridayId), Saturday(freshSaturdayId), Sunday(freshSundayId)
                )
//            inserting  week + lists with meals
                homeViewModel.insertOneWeek(Week("tydzień $freshWeekId opis",freshWeekId))
                homeViewModel.insertWholeWeek(
                    mondayList,
                    tuesdayList,
                    wednesdayList,
                    thursdayList,
                    fridayList,
                    saturdayList,
                    sundayList
                )
                dismiss()
                Toast.makeText(requireContext(), "przeszło", Toast.LENGTH_SHORT).show()
//            inserting one day of the week
//                homeViewModel.insertWholeWeek(
//                    listOf(MondayMealCrossRef(freshMondayId,2),MondayMealCrossRef(freshMondayId,5),MondayMealCrossRef(freshMondayId,1)),
//                    listOf(TuesdayMealCrossRef(freshTuesdayId,3),TuesdayMealCrossRef(freshTuesdayId,2),TuesdayMealCrossRef(freshTuesdayId,4)),
//                    listOf(WednesdayMealCrossRef(freshWednesdayId,4),WednesdayMealCrossRef(freshWednesdayId,1),WednesdayMealCrossRef(freshWednesdayId,2)),
//                    listOf(ThursdayMealCrossRef(freshThursdayId,1),ThursdayMealCrossRef(freshThursdayId,5),ThursdayMealCrossRef(freshThursdayId,6)),
//                    listOf(FridayMealCrossRef(freshFridayId,2),FridayMealCrossRef(freshFridayId,5),FridayMealCrossRef(freshFridayId,1)),
//                    listOf(SaturdayMealCrossRef(freshSaturdayId,4), SaturdayMealCrossRef(freshSaturdayId,6), SaturdayMealCrossRef(freshSaturdayId,1)),
//                    listOf(SundayMealCrossRef(freshSundayId,1), SundayMealCrossRef(freshSundayId,2),SundayMealCrossRef(freshSundayId,5))
//                )
                Toast.makeText(requireContext(), "Week has been added", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(requireContext(), "Fill in the blanks before save!", Toast.LENGTH_SHORT).show()
            }

        }
            homeViewModel.lastMondayId.observe(viewLifecycleOwner){
                freshMondayId = if(it == null){
                    0
                }else{
                    it + 1
                }
            }
            homeViewModel.lastTuesdayId.observe(viewLifecycleOwner){
                freshTuesdayId = if(it == null){
                    0
                }else{
                    it + 1
                }
            }
            homeViewModel.lastWednesdayId.observe(viewLifecycleOwner){
                freshWednesdayId = if(it == null){
                    0
                }else{
                    it + 1
                }
            }
            homeViewModel.lastThursdayId.observe(viewLifecycleOwner){
                freshThursdayId = if(it == null){
                    0
                }else{
                    it + 1
                }
            }
            homeViewModel.lastFridayId.observe(viewLifecycleOwner){
                freshFridayId = if(it == null){
                    0
                }else{
                    it + 1
                }
            }
            homeViewModel.lastSaturdayId.observe(viewLifecycleOwner){
                freshSaturdayId = if(it == null){
                    0
                }else{
                    it + 1
                }

            }
            homeViewModel.lastSundayId.observe(viewLifecycleOwner){
                freshSundayId = if(it == null){
                    0
                }else{
                    it + 1
                }
            }
            homeViewModel.lastWeekId.observe(viewLifecycleOwner){
                freshWeekId = if(it == null){
                    0
                }else{
                    it + 1
                }
            }
    }
}