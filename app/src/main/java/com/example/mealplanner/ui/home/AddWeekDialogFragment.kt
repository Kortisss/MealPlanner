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

        val mealNameList = mutableListOf<String>()
        mealNameList.add("")
        mealNameList.addAll(mealList.map { s -> s.name })
        val adapterMealList = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, mealNameList)

        spinnerMonday1.adapter = adapterMealList
        spinnerMonday2.adapter = adapterMealList
        spinnerMonday3.adapter = adapterMealList
        spinnerTuesday1.adapter = adapterMealList
        spinnerTuesday2.adapter = adapterMealList
        spinnerTuesday3.adapter = adapterMealList
        spinnerWednesday1.adapter = adapterMealList
        spinnerWednesday2.adapter = adapterMealList
        spinnerWednesday3.adapter = adapterMealList
        spinnerThursday1.adapter = adapterMealList
        spinnerThursday2.adapter = adapterMealList
        spinnerThursday3.adapter = adapterMealList
        spinnerFriday1.adapter = adapterMealList
        spinnerFriday2.adapter = adapterMealList
        spinnerFriday3.adapter = adapterMealList
        spinnerSaturday1.adapter = adapterMealList
        spinnerSaturday2.adapter = adapterMealList
        spinnerSaturday3.adapter = adapterMealList
        spinnerSunday1.adapter = adapterMealList
        spinnerSunday2.adapter = adapterMealList
        spinnerSunday3.adapter = adapterMealList

        val spinnersPositionCheck = MutableList(21) { false }

        fun changeAdapter(adapter: ArrayAdapter<String>, position: Int){

//            adapter.clear()
//            val list = mutableListOf<String>()
//            list.add("")
//            list.addAll((mealList.map { n -> n.name }))
//            list.removeAt(position)
//            adapter.addAll(list)
            adapter.remove(mealNameList[position])
            adapter.notifyDataSetChanged()

            println()
        }

        //todo: Zmieniać listę tak żeby po wybraniu w spinnermonday1 wybrany element nie pokazał się w spinnermonday2 i 3
        //todo: z powodu integracji bazy danych posiłki nie mogą się powtarzać
        spinnerMonday1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?, position: Int, id: Long) {
              if (position != 0){

                  spinnersPositionCheck[0] = true
                    if (mondayList.size == 1){
                        mondayList.removeAt(0)
                    }
                  mondayList.add(MondayMealCrossRef(freshMondayId,mealList[position-1].mealId))

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
                    mondayList.add(MondayMealCrossRef(freshMondayId,mealList[position-1].mealId))
                    spinnerMonday3.isEnabled = true
                }else{
                    spinnersPositionCheck[1] = false
                }
            }
            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
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
                    mondayList.add(MondayMealCrossRef(freshMondayId,mealList[position-1].mealId))
                    spinnerTuesday1.isEnabled = true
                }else{
                    spinnersPositionCheck[2] = false
                }
            }
            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
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
                    tuesdayList.add(TuesdayMealCrossRef(freshTuesdayId,mealList[position-1].mealId))
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
                    tuesdayList.add(TuesdayMealCrossRef(freshTuesdayId,mealList[position-1].mealId))
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
                    tuesdayList.add(TuesdayMealCrossRef(freshTuesdayId,mealList[position-1].mealId))
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
                    wednesdayList.add(WednesdayMealCrossRef(freshWednesdayId,mealList[position-1].mealId))
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
                    wednesdayList.add(WednesdayMealCrossRef(freshWednesdayId,mealList[position-1].mealId))
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
                    wednesdayList.add(WednesdayMealCrossRef(freshWednesdayId,mealList[position-1].mealId))
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
                    thursdayList.add(ThursdayMealCrossRef(freshThursdayId,mealList[position-1].mealId))
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
                    thursdayList.add(ThursdayMealCrossRef(freshThursdayId,mealList[position-1].mealId))
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
                    thursdayList.add(ThursdayMealCrossRef(freshThursdayId,mealList[position-1].mealId))
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
                    fridayList.add(FridayMealCrossRef(freshFridayId,mealList[position-1].mealId))
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
                    fridayList.add(FridayMealCrossRef(freshFridayId,mealList[position-1].mealId))
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
                    fridayList.add(FridayMealCrossRef(freshFridayId,mealList[position-1].mealId))
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
                    saturdayList.add(SaturdayMealCrossRef(freshSaturdayId,mealList[position-1].mealId))
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
                    saturdayList.add(SaturdayMealCrossRef(freshSaturdayId,mealList[position-1].mealId))
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
                    saturdayList.add(SaturdayMealCrossRef(freshSaturdayId,mealList[position-1].mealId))
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
                    sundayList.add(SundayMealCrossRef(freshSundayId,mealList[position-1].mealId))
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
                    sundayList.add(SundayMealCrossRef(freshSundayId,mealList[position-1].mealId))
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
                    sundayList.add(SundayMealCrossRef(freshSundayId,mealList[position-1].mealId))
                }else{
                    spinnersPositionCheck[20] = false
                }
            }
            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }

        btnAddWeek.setOnClickListener{
            //tutaj warunki co do poprawości danych w spinnerach
            //potem dodaje cos do bazy
                if (spinnersPositionCheck.containsAll(listOf(true))){
                    homeViewModel.insertDayweeks(Monday(), Tuesday(), Wednesday(), Thursday(),
                        Friday(), Saturday(), Sunday()
                    )
//            inserting  week + lists with meals
                    homeViewModel.insertOneWeek(Week("tydzień $freshWeekId opis"))

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
                }else{
                    Toast.makeText(requireContext(), "Fill in the blanks before save!", Toast.LENGTH_SHORT).show()
                }
//            inserting one day of the week
            
//            homeViewModel.insertWholeWeek(
//                listOf(MondayMealCrossRef(freshMondayId,2),MondayMealCrossRef(freshMondayId,5),MondayMealCrossRef(freshMondayId,1)),
//                listOf(TuesdayMealCrossRef(freshTuesdayId,3),TuesdayMealCrossRef(freshTuesdayId,2),TuesdayMealCrossRef(freshTuesdayId,4)),
//                listOf(WednesdayMealCrossRef(freshWednesdayId,4),WednesdayMealCrossRef(freshWednesdayId,1),WednesdayMealCrossRef(freshWednesdayId,2)),
//                listOf(ThursdayMealCrossRef(freshThursdayId,1),ThursdayMealCrossRef(freshThursdayId,5),ThursdayMealCrossRef(freshThursdayId,6)),
//                listOf(FridayMealCrossRef(freshFridayId,2),FridayMealCrossRef(freshFridayId,5),FridayMealCrossRef(freshFridayId,1)),
//                listOf(SaturdayMealCrossRef(freshSaturdayId,4), SaturdayMealCrossRef(freshSaturdayId,6), SaturdayMealCrossRef(freshSaturdayId,1)),
//                listOf(SundayMealCrossRef(freshSundayId,1), SundayMealCrossRef(freshSundayId,2),SundayMealCrossRef(freshSundayId,5))
//            )
        }
            homeViewModel.lastMondayId.observe(viewLifecycleOwner){
                freshMondayId = it + 1
            }
            homeViewModel.lastTuesdayId.observe(viewLifecycleOwner){
                freshTuesdayId = it + 1
            }
            homeViewModel.lastWednesdayId.observe(viewLifecycleOwner){
                freshWednesdayId = it + 1
            }
            homeViewModel.lastThursdayId.observe(viewLifecycleOwner){
                freshThursdayId = it+ 1
            }
            homeViewModel.lastFridayId.observe(viewLifecycleOwner){
                freshFridayId = it + 1
            }
            homeViewModel.lastSaturdayId.observe(viewLifecycleOwner){
                freshSaturdayId = it + 1
            }
            homeViewModel.lastSundayId.observe(viewLifecycleOwner){
                freshSundayId = it + 1
            }
            homeViewModel.lastWeekId.observe(viewLifecycleOwner){
                freshWeekId = it + 1
            }
    }
}