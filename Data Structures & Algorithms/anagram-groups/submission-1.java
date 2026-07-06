class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<HashMap<Character, Integer>, List<String>> bigHm = new HashMap<>() ;
        for(String str : strs){
            HashMap<Character, Integer> smallHm = new HashMap<>() ;
            for(int i = 0 ; i<str.length(); i++){
                if(smallHm.containsKey(str.charAt(i))){
                    smallHm.put(str.charAt(i), smallHm.get(str.charAt(i))+1) ;
                }else{
                    smallHm.put(str.charAt(i), 1) ;
                }
            }

            if(!bigHm.containsKey(smallHm)){
                List<String> list = new ArrayList<>() ;
                list.add(str) ;
                bigHm.put(smallHm, list) ;
            }else{
                List<String> list = bigHm.get(smallHm) ;
                list.add(str) ;
            }
        }

        List<List<String>> result = new ArrayList<>() ;
        for(List<String> temp : bigHm.values()){
            result.add(temp) ;
        }
        return result ;

    }
}
